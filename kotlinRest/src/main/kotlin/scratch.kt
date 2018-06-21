import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Klaxon
import com.beust.klaxon.Parser
import com.icoderman.woocommerce.EndpointBaseType
import com.icoderman.woocommerce.HttpMethod
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.result.getOrElse
import com.oauth1.OAuthConfig
import com.oauth1.OAuthSignature
import com.woocommerce.model.Product
import java.util.*


fun main(args: Array<String>) {
    val params = HashMap<String, String>()
    //params["offset"] = "0"
    params["fields"]=OAuthSignature.replaceSpecialChars("title,id,description" )// doesn't work if we add multiple fields here, %2C is ,remember capital C
   params["filter%5Blimit%5D"] = "100"
    val productsJson= wooCommerceLegacyV3Fuel.getAll(EndpointBaseType.PRODUCTS.value, params)
    println(productsJson)
    parseProducts(productsJson)

}



data class productsMapper (
    val products: List<Product>
)

// the product object for v3 is different thatn model may be that's why it's failing
// create object from json then try again for time being use json object
fun parseProducts( productsJson: String) {
    val parser: Parser = Parser()
    val productsObjs =parser.parse(StringBuilder(productsJson)) as JsonObject
    val productsArray=productsObjs.get("products") as JsonArray<JsonObject>
    productsArray.forEach {product ->
    println(product.string("title") + "::" )//+product.string("description"))
    }



}


object wooCommerceLegacyV3Fuel {
    private val API_URL_FORMAT = "%s/wc-api/%s/%s"
    private val API_URL_ONE_ENTITY_FORMAT = "%s/wc-api/%s/%s/%d"
    private val URL_SECURED_FORMAT = "%s?%s"

    private val config: OAuthConfig =  OAuthConfig("http://www.nepalconstructionmart.com", "ck_b3b26bf14e1193829ec21ca2c8ae355be3855fc6", "cs_69ddf520c834a509c41557c4ab145b8c24e0754e")
    private val apiVersion: String? = "v3"

   // fun getAll(endpointBase: String, params: List<Pair<String, Any?>>): List<*> {
   fun getAll(endpointBase: String, params: Map<String, String>): String{
        val url = String.format(API_URL_FORMAT, config.url, apiVersion, endpointBase)
        val signature = OAuthSignature.getAsQueryString(config, url, HttpMethod.GET, params)
        val securedUrl = String.format(URL_SECURED_FORMAT, url, signature)
        // return client.getAll(securedUrl)

       println("securedUrl: " + securedUrl)
        //use fuel here
        val (request, response, result) = Fuel.get(securedUrl).responseString()
       println(response.toString())
        val jsonResult = result.getOrElse("Error")
        return jsonResult
    }
}


