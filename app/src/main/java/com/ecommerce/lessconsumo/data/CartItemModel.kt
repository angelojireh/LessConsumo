package com.ecommerce.lessconsumo.data

data class CartItemModel (var id: Int,
                          var quantity: Int = 0,
                          var name: String,
                          var image: String,
                          var price: String)