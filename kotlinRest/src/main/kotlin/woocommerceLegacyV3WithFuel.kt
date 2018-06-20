import com.icoderman.woocommerce.ApiVersionType
import com.icoderman.woocommerce.EndpointBaseType
import com.icoderman.woocommerce.WooCommerceAPI
import com.icoderman.woocommerce.oauth.OAuthConfig
import java.util.HashMap

object wooCommerceLegacyV3 {
    fun main(args: Array<String>) {
        retriveProducts()
    }


    fun retriveProducts() {
        val url="http://www.nepalconstructionmart.com"
        val ck="ck_b3b26bf14e1193829ec21ca2c8ae355be3855fc6"
        val cs="cs_69ddf520c834a509c41557c4ab145b8c24e0754e"


        //


    }


    fun getProducts() {
        val config = OAuthConfig("http://www.nepalconstructionmart.com", "ck_b3b26bf14e1193829ec21ca2c8ae355be3855fc6", "cs_69ddf520c834a509c41557c4ab145b8c24e0754e")

        // check version in http://www.nepalconstructionmart.com/wp-json/
        // check namespace what  has wc/v1 as value
        val wooCommerce = WooCommerceAPI(config, ApiVersionType.V1)

        // Get all with request parameters

        val params = HashMap<String, String>()
        println("Categories: ")
        params["per_page"] = "10"
        params["offset"] = "0"

        // categories
        val categories = wooCommerce.getAll(EndpointBaseType.PRODUCTS_CATEGORIES.value, params)
        categories.forEach { category ->
            val cMap = category as HashMap<String, Any>
            println("Category: " + cMap["name"])
        }

        println("Products: ")
        params["per_page"] = "10"
        params["offset"] = "10"
        val products = wooCommerce.getAll(EndpointBaseType.PRODUCTS.value, params)
        // iterate over the list and convert it to product object
        // the products is list of hash maps.
        products.forEach { product ->
            val pMap = product as HashMap<String, Any>
            println("Product: " + pMap["id"] + " : " + pMap["name"])
        }

        println("Searching product: ")
        val resultProducts = wooCommerce.get(EndpointBaseType.PRODUCTS.value, 10592)
        println(resultProducts)

    }
}