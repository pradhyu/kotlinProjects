
data class Product(
		val id: Int,
		val name: String,
		val slug: String,
		val permalink: String,
		val date_created: String,
		val date_modified: String,
		val type: String,
		val status: String,
		val featured: Boolean,
		val catalog_visibility: String,
		val description: String,
		val short_description: String,
		val sku: String,
		val price: String,
		val regular_price: String,
		val sale_price: String,
		val date_on_sale_from: String,
		val date_on_sale_to: String,
		val price_html: String,
		val on_sale: Boolean,
		val purchasable: Boolean,
		val total_sales: Int,
		val virtual: Boolean,
		val downloadable: Boolean,
		val downloads: List<Any>,
		val download_limit: Int,
		val download_expiry: Int,
		val download_type: String,
		val external_url: String,
		val button_text: String,
		val tax_status: String,
		val tax_class: String,
		val manage_stock: Boolean,
		val in_stock: Boolean,
		val backorders: String,
		val backorders_allowed: Boolean,
		val backordered: Boolean,
		val sold_individually: Boolean,
		val weight: String,
		val dimensions: Dimensions,
		val shipping_required: Boolean,
		val shipping_taxable: Boolean,
		val shipping_class: String,
		val shipping_class_id: Int,
		val reviews_allowed: Boolean,
		val average_rating: String,
		val rating_count: Int,
		val related_ids: List<Any>,
		val upsell_ids: List<Any>,
		val cross_sell_ids: List<Any>,
		val parent_id: Int,
		val purchase_note: String,
		val categories: List<Any>,
		val tags: List<Any>,
		val images: List<Image>,
		val attributes: List<Any>,
		val default_attributes: List<Any>,
		val variations: List<Any>,
		val grouped_products: List<Any>,
		val menu_order: Int,
		val _links: Links
)

data class Image(
		val id: Int,
		val date_created: String,
		val date_modified: String,
		val src: String,
		val name: String,
		val alt: String,
		val position: Int
)

data class Links(
		val self: List<Self>,
		val collection: List<Collection>
)

data class Collection(
		val href: String
)

data class Self(
		val href: String
)

data class Dimensions(
		val length: String,
		val width: String,
		val height: String
)