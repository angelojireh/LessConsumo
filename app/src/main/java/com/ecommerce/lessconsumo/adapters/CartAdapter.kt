package com.ecommerce.lessconsumo.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.data.ShoppingCartRepository
import com.ecommerce.lessconsumo.data.CartItemModel
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.activity_cart.view.*
import kotlinx.android.synthetic.main.layout_cart_items.view.*
import java.text.NumberFormat
import java.util.*

class CartAdapter(val context: Context, var cartItems: List<CartItemModel>, private val mListener: RemoveItemListener) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_cart_items, parent, false))
    }

    override fun getItemCount(): Int = cartItems.size

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bindItem(cartItems[position])
        holder.itemView.cartItemRemove.setOnClickListener {
            removeFromBag(position) //remove item
            cartItems = ShoppingCartRepository.getCart() //get updated cart and notify adapter of the changes
            notifyDataSetChanged()
            mListener.removeItemClicked()
            Log.i("paperDB", ShoppingCartRepository.getCart().toString())
        }
    }

    private fun removeFromBag(position: Int){
        val item = CartItemModel(cartItems[position].id, 1, cartItems[position].name, cartItems[position].image, cartItems[position].price)
        ShoppingCartRepository.removeItem(item, context)
    }



    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(cartItem: CartItemModel) {
            loadPicassoImage(cartItem.image, itemView.cartItemImage)
            itemView.cartItemName.text = cartItem.name
            itemView.cartItemPrice.text = cartItem.price
        }

        fun loadPicassoImage(image: String, imageView: ImageView) {
            Picasso.get()
                .load(image)
                .resize(450,450)
                .centerCrop()
                .into(imageView)
        }
    }

    //interface for removing items then updating subtotal in activity
    interface RemoveItemListener{
        fun removeItemClicked()
    }
}