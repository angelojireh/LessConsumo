package com.ecommerce.lessconsumo.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.customclass.ShoppingCart
import com.ecommerce.lessconsumo.data.CartItem
import com.squareup.picasso.Picasso
import io.reactivex.ObservableOnSubscribe
import kotlinx.android.synthetic.main.layout_cart_items.view.*
import java.net.URI.create
import java.util.*

class CartAdapter(val context: Context, var cartItems: List<CartItem>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartAdapter.CartViewHolder {
        return CartViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_cart_items, parent, false))
    }

    override fun getItemCount(): Int = cartItems.size

    override fun onBindViewHolder(holder: CartAdapter.CartViewHolder, position: Int) {

        holder.bindItem(cartItems[position])
        holder.itemView.cartItemRemove.setOnClickListener(View.OnClickListener {
            //remove item
            removeFromBag(position)

            //get updated cart and notify adapter of the changes
            cartItems = ShoppingCart.getCart()
            notifyDataSetChanged()
            Log.i("paperDB", ShoppingCart.getCart().toString())
        })
    }

    private fun removeFromBag(position: Int){
        val item = CartItem(cartItems[position].id, 1, cartItems[position].name, cartItems[position].image, cartItems[position].price)
        ShoppingCart.removeItem(item, context)
    }

    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(cartItem: CartItem) {
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
}