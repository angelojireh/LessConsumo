package com.ecommerce.lessconsumo.data

data class OrderModel(
        var payment_method: String,
        var payment_method_title: String,
        var set_paid: Boolean,
        var billing: Billing,
        var shipping: Shipping,
        var line_items: List<LineItem>,
        var shipping_lines: List<ShippingLine>
) {
    data class Billing(
            var address_1: String,
            var address_2: String,
            var city: String,
            var country: String,
            var email: String,
            var first_name: String,
            var last_name: String,
            var phone: String,
            var postcode: String,
            var state: String
    )

    data class Shipping(
            var address_1: String,
            var address_2: String,
            var city: String,
            var country: String,
            var first_name: String,
            var last_name: String,
            var postcode: String,
            var state: String
    )

    data class LineItem(
            var product_id: Int,
            var quantity: Int,
            var variation_id: Int
    )

    data class ShippingLine(
            var method_id: String,
            var method_title: String,
            var total: String
    )
}