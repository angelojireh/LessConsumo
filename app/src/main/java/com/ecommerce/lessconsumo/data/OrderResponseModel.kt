package com.ecommerce.lessconsumo.data

data class OrderResponseModel(
    val id: Int,
    val parent_id: Int,
    val number: String,
    val order_key: String,
    val created_via: String,
    val version: String,
    val status: String,
    val currency: String,
    val date_created: String,
    val date_created_gmt: String,
    val date_modified: String,
    val date_modified_gmt: String,
    val discount_total: String,
    val discount_tax: String,
    val shipping_total: String,
    val shipping_tax: String,
    val cart_tax: String,
    val total: String,
    val total_tax: String,
    val prices_include_tax: Boolean,
    val customer_id: Int,
    val customer_ip_address: String,
    val customer_user_agent: String,
    val customer_note: String,
    val billing: Billing,
    val shipping: Shipping,
    val payment_method: String,
    val payment_method_title: String,
    val transaction_id: String,
    val date_paid: String,
    val date_paid_gmt: String,
    val date_completed: Any,
    val date_completed_gmt: Any,
    val cart_hash: String,
    val meta_data: List<MetaData>,
    val line_items: List<LineItem>,
    val tax_lines: List<TaxLine>,
    val shipping_lines: List<ShippingLine>,
    val fee_lines: List<Any>,
    val coupon_lines: List<Any>,
    val refunds: List<Any>,
    val _links: Links
) {
    data class Billing(
        val first_name: String,
        val last_name: String,
        val company: String,
        val address_1: String,
        val address_2: String,
        val city: String,
        val state: String,
        val postcode: String,
        val country: String,
        val email: String,
        val phone: String
    )

    data class Shipping(
        val first_name: String,
        val last_name: String,
        val company: String,
        val address_1: String,
        val address_2: String,
        val city: String,
        val state: String,
        val postcode: String,
        val country: String
    )

    data class MetaData(
        val id: Int,
        val key: String,
        val value: String
    )

    data class LineItem(
        val id: Int,
        val name: String,
        val product_id: Int,
        val variation_id: Int,
        val quantity: Int,
        val tax_class: String,
        val subtotal: String,
        val subtotal_tax: String,
        val total: String,
        val total_tax: String,
        val taxes: List<Taxe>,
        val meta_data: List<MetaData>,
        val sku: String,
        val price: Int
    ) {
        data class Taxe(
            val id: Int,
            val total: String,
            val subtotal: String
        )

        data class MetaData(
            val id: Int,
            val key: String,
            val value: String
        )
    }

    data class TaxLine(
        val id: Int,
        val rate_code: String,
        val rate_id: Int,
        val label: String,
        val compound: Boolean,
        val tax_total: String,
        val shipping_tax_total: String,
        val meta_data: List<Any>
    )

    data class ShippingLine(
        val id: Int,
        val method_title: String,
        val method_id: String,
        val total: String,
        val total_tax: String,
        val taxes: List<Any>,
        val meta_data: List<Any>
    )

    data class Links(
        val self: List<Self>,
        val collection: List<Collection>
    ) {
        data class Self(
            val href: String
        )

        data class Collection(
            val href: String
        )
    }
}