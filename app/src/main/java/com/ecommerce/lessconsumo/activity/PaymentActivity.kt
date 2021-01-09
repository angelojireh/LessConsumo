package com.ecommerce.lessconsumo.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.data.OrderModel
import com.ecommerce.lessconsumo.data.ShoppingCartRepository
import com.example.lesscon.home.data.HomeRepository
import com.example.lesscon.home.viewmodel.HomeViewModel
import com.google.android.material.snackbar.Snackbar
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_payment.*
import java.text.NumberFormat
import java.util.*

class PaymentActivity : AppCompatActivity(), View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private lateinit var mHomeViewModel: HomeViewModel

    private var responseID = 0
    private lateinit var responseStatus: String

    private lateinit var address_1: String
    private lateinit var city: String
    private lateinit var country: String
    private lateinit var email: String
    private lateinit var first_name: String
    private lateinit var last_name: String
    private lateinit var phone: String
    private lateinit var postcode: String
    private lateinit var state: String
    private var subtotal = 0.00
    private lateinit var shipping_method_id: String
    private lateinit var shipping_method_title: String
    private var shipping_fee = 0.00

    private lateinit var payment_method: String
    private lateinit var payment_method_title: String
    private var total = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        //PaperDB initialization
        Paper.init(applicationContext)
        getExtras()
        setTexts()
        initOnClickListener()
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.buttonBackPayment -> this.finish()
            R.id.buttonComplete ->
                if(rg_payment.checkedRadioButtonId != -1) {
                    progress_payment.visibility = View.VISIBLE
                    completeOrder()
                } else showSnackBar(payment_view, "Please select a payment method")
        }
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when(group?.checkedRadioButtonId){
            R.id.rb_bacs -> {
                textview_bacs.visibility = View.VISIBLE
                payment_method = "bacs"
                payment_method_title = "Direct bank transfer"
            }
            R.id.rb_cod -> {
                textview_bacs.visibility = View.GONE
                payment_method = "cod"
                payment_method_title = "Cash on delivery (C.O.D.)"
            }
        }
    }

    private fun completeOrder() {
        val billing = OrderModel.Billing(address_1, "",city, country, email, first_name, last_name, phone, postcode, state)
        val shipping = OrderModel.Shipping(address_1, "", city, country, first_name, last_name, postcode, state)
        val shippinglines = arrayListOf<OrderModel.ShippingLine>()
        val items = arrayListOf<OrderModel.LineItem>()
        val shoppingCart = ShoppingCartRepository.getCart()

        for(i in shoppingCart.indices) {
            items.add(OrderModel.LineItem(shoppingCart[i].id, shoppingCart[i].quantity, 0))
        }
        shippinglines.add(OrderModel.ShippingLine(shipping_method_id, shipping_method_title, shipping_fee.toString()))

        val orderData = OrderModel(payment_method, payment_method_title, false, billing, shipping, items, shippinglines)
        mHomeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        mHomeViewModel.postOrder(orderData)
        mHomeViewModel.orderResponseModelLiveData?.observe(this, Observer{
            if(it != null) {
                responseID = it.id
                responseStatus = it.status
                Paper.book().delete("cart")
                progress_payment.visibility = View.GONE
                //go to confirmation activity
                gotoNewActivity(ConfirmationActivity())
            }
        })
    }

    private fun initOnClickListener()
    {
        buttonBackPayment.setOnClickListener(this)
        buttonComplete.setOnClickListener(this)
        rg_payment.setOnCheckedChangeListener(this)
    }

    private fun gotoNewActivity(activity : Activity) {
        val i = Intent (this, activity::class.java)
        i.putExtra("responseID", responseID)
        i.putExtra("responseStatus", responseStatus)
        startActivity(i)
    }

    private fun showSnackBar(view: View, msg: String){
        Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show()
    }

    private fun getExtras() {
        val b: Bundle? = intent.extras
        if(b != null){
            address_1 = b.getString("address_1").toString()
            city = b.getString("city").toString()
            country = b.getString("country").toString()
            email = b.getString("email").toString()
            first_name = b.getString("first_name").toString()
            last_name = b.getString("last_name").toString()
            phone = b.getString("phone").toString()
            postcode = b.getString("postcode").toString()
            state = b.getString("state").toString()
            subtotal = b.getDouble("subtotal")
            shipping_method_id = b.getString("shipping_method_id").toString()
            shipping_method_title = b.getString("shipping_method_title").toString()
            shipping_fee = b.getDouble("shipping_fee")
        }
        total = subtotal + shipping_fee
    }

    private fun setTexts() {
        textview_subtotal_price.text = currencyFormatter(subtotal)
        textview_shipping_fee.text = currencyFormatter(shipping_fee)
        textview_total_price.text = currencyFormatter(total)
    }

    private fun currencyFormatter(mNumber: Double): String
    {
        val mNumberFormat: NumberFormat = NumberFormat.getCurrencyInstance()
        mNumberFormat.maximumFractionDigits = 2
        mNumberFormat.currency = Currency.getInstance("PHP")
        return (mNumberFormat.format(mNumber)).toString()
    }
}