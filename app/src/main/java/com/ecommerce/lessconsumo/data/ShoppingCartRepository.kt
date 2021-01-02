package com.ecommerce.lessconsumo.data

import android.content.Context
import io.paperdb.Paper

class ShoppingCartRepository {
    companion object{

        fun addItem(cartItem: CartItemModel){
            val cart = getCart()
            val targetItem = cart.singleOrNull { it.id == cartItem.id }
            if(targetItem == null) {
                cart.add(cartItem)
            }
            saveCart(cart)
        }

        fun removeItem(cartItem: CartItemModel, context: Context) {
            val cart = getCart()
            val targetItem = cart.singleOrNull { it.id == cartItem.id }
            if(targetItem != null){
                cart.remove(targetItem)
            }
            saveCart(cart)
        }

        fun saveCart(cart: MutableList<CartItemModel>) {
            Paper.book().write("cart", cart)
        }

        fun getCart(): MutableList<CartItemModel> {
            return Paper.book().read("cart", mutableListOf())
        }
    }
}