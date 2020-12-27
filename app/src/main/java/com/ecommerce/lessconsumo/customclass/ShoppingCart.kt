package com.ecommerce.lessconsumo.customclass

import android.content.Context
import com.ecommerce.lessconsumo.data.CartItem
import io.paperdb.Paper

class ShoppingCart {
    companion object{

        fun addItem(cartItem: CartItem){
            val cart = getCart()
            val targetItem = cart.singleOrNull { it.id == cartItem.id }
            if(targetItem == null) {
                cart.add(cartItem)
            }
            saveCart(cart)
        }

        fun removeItem(cartItem: CartItem, context: Context) {
            val cart = getCart()
            val targetItem = cart.singleOrNull { it.id == cartItem.id }
            if(targetItem != null){
                cart.remove(targetItem)
            }
            saveCart(cart)
        }

        fun saveCart(cart: MutableList<CartItem>) {
            Paper.book().write("cart", cart)
        }

        fun getCart(): MutableList<CartItem> {
            return Paper.book().read("cart", mutableListOf())
        }
    }
}