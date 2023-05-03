package com.example.ClothsStore.activity

data class productListModel(
    val `data`: List<Datas>,
    val message: String,
    val status: Int
)
data class Datas(
    val admin_graphql_api_id: String,
    val body_html: String,
    val created_at: String,
    val handle: String,
    val id: Long,
    val image: Image,
    val images: List<Image>,
    val options: List<Option>,
    val product_type: String,
    val published_at: String,
    val published_scope: String,
    val status: String,
    val tags: String,
    val template_suffix: String,
    val title: String,
    val updated_at: String,
    val variants: List<Variant>,
    val vendor: String
) : java.io.Serializable
data class Variant(
    val admin_graphql_api_id: String,
    val barcode: String,
    val compare_at_price: String,
    val created_at: String,
    val fulfillment_service: String,
    val grams: Int,
    val id: Long,
    val image_id: Any,
    val inventory_item_id: Long,
    val inventory_management: String,
    val inventory_policy: String,
    val inventory_quantity: Int,
    val old_inventory_quantity: Int,
    val option1: String,
    val option2: String,
    val option3: String,
    val position: Int,
    val price: String,
    val product_id: Long,
    val requires_shipping: Boolean,
    val sku: String,
    val taxable: Boolean,
    val title: String,
    val updated_at: String,
    val weight: Int,
    val weight_unit: String
) : java.io.Serializable
data class Option(
    val id: Long,
    val name: String,
    val position: Int,
    val product_id: Long,
    val values: List<String>
): java.io.Serializable
data class Image(
    val admin_graphql_api_id: String,
    val alt: Any,
    val created_at: String,
    val height: Int,
    val id: Long,
    val position: Int,
    val product_id: Long,
    val src: String,
    val updated_at: String,
    val variant_ids: List<Any>,
    val width: Int
): java.io.Serializable


