import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.httpGet


    fun main(args: Array<String>) {
        println("Hello, world!")

        FuelManager.instance.basePath = "http://httpbin.org"
        "/get".httpGet().responseString {
            request, response, result ->
            //make a GET to http://httpbin.org/get and do something with response
            val (data, error) = result
            if (error == null) {
                //do something when success
                println(data)
            } else {
                //error handling
            }
        }
    }

