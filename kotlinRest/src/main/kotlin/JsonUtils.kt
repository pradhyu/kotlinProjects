import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import java.io.File
import Product
import com.beust.klaxon.JsonArray
import com.beust.klaxon.Klaxon


fun parse(name: String) : Any? {
    val cls = Parser::class.java
    return cls.getResourceAsStream(name)?.let { inputStream ->
        return Parser().parse(inputStream)
    }
}

fun main(args: Array<String>) {

    println(productsList())
}

fun product1 () {
    // readText is a extension function
    val productFilePath = "src/main/resources/product.json"
    val personJsonPath="src/main/resources/person.json"

    // use parse if the json is object otherwise use parse Array
    val people = Klaxon().parseArray<Person>(File(personJsonPath).readText())
    println(people)
    val products = Klaxon().parseArray<Product>(File(productFilePath).readText())
    // add null safe for foreach
    products?.forEach {
        println(it.id.toString() + ": " + it.name)
    }

}

fun productsList (): List<Product>?  {
    val PRODUCTS_JSON_PATH = "/Users/pkshrestha/AndroidStudioProjects/wallclock/app/product.json"
    val jsonContent = File(PRODUCTS_JSON_PATH).readText()
    val jsonArray=Klaxon().parseArray<Product>(jsonContent)
    return jsonArray
}
