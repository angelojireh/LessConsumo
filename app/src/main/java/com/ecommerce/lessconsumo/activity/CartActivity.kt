package com.ecommerce.lessconsumo.activity

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.adapters.CartAdapter
import com.ecommerce.lessconsumo.data.CartItemModel
import com.ecommerce.lessconsumo.data.ShoppingCartRepository
import com.google.android.material.snackbar.Snackbar
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_cart.*
import java.text.NumberFormat
import java.util.*

class CartActivity : AppCompatActivity(), View.OnClickListener, CartAdapter.RemoveItemListener {

    private lateinit var mCartAdapter: CartAdapter
    private lateinit var mLinearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        //PaperDB initialization
        Paper.init(applicationContext)
        initButtonClickListener()
        initCartAdapter()
        getSubTotal()
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.buttonBackCart -> this.finish()
            R.id.buttonCheckout -> gotoNewActivity(InformationActivity())
        }
    }

    private fun gotoNewActivity(activity : Activity) {
        val i = Intent (this, activity::class.java)
        i.putExtra("subtotal", removeCurrencySymbol(textview_subtotal_price.text.toString()).toDouble())
        startActivity(i)
    }

    private fun initButtonClickListener() {
        buttonBackCart.setOnClickListener(this)
        buttonCheckout.setOnClickListener(this)
    }

    private fun initCartAdapter() {
        mLinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mCartAdapter = CartAdapter(this, ShoppingCartRepository.getCart(), this)
        recyclerView_cart.setHasFixedSize(true)
        recyclerView_cart.layoutManager = mLinearLayoutManager
        recyclerView_cart.adapter = mCartAdapter
    }

    private fun getSubTotal(){
        var subtotal = 0.00
        if(ShoppingCartRepository.getCart().isNotEmpty()){
            val items: List<CartItemModel> = ShoppingCartRepository.getCart()
            for(i in items){
                if(i.price.isNotEmpty()) {
                    subtotal += (removeCurrencySymbol(i.price)).toDouble()
                }
            }
            textview_subtotal_price.text = currencyFormatter(subtotal)
            Snackbar.make(cart_activity_view, "Cart updated.", Snackbar.LENGTH_SHORT).show()
        } else {
            textview_subtotal_price.text = currencyFormatter(0.00)
            disableCheckout()
            Snackbar.make(cart_activity_view, "Your cart is empty.", Snackbar.LENGTH_SHORT).show()
        }
    }

    fun removeCurrencySymbol(price: String): String{
        val format: NumberFormat = NumberFormat.getCurrencyInstance()
        val number: Number = format.parse(price)!!
        return number.toString()
    }

    fun currencyFormatter(mNumber: Double): String
    {
        val mNumberFormat: NumberFormat = NumberFormat.getCurrencyInstance()
        mNumberFormat.maximumFractionDigits = 2
        mNumberFormat.currency = Currency.getInstance("PHP")
        return (mNumberFormat.format(mNumber)).toString()
    }

    fun disableCheckout(){
        buttonCheckout.isEnabled = false
        buttonCheckout.setBackgroundResource(R.drawable.background_button_uncolored)
    }

    //interface from cart adapter
    override fun removeItemClicked() {
        getSubTotal()
    }
}