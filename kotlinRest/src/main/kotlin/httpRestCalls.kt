import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.httpGet


fun main(args: Array<String>) {
    println("Hello, world!")
    testHttp()
    getWeather()
}


object Log {
    fun i(tag: String, msg: String?) {
        println(tag + " : " + msg)
    }

    fun e(tag: String, msg: String?) {
        println(tag + " : " + msg)

    }
}

fun testHttp() {
    FuelManager.instance.basePath = "http://httpbin.org"
    "/get".httpGet().responseString { request, response, result ->
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


fun getWeather() {
    Log.i("weather", "Get Weather")
    val formdata = listOf("q" to "cary,us", "appid" to "b6907d289e10d714a6e88b30761fae22")
    Fuel.get("http://openweathermap.org/data/2.5/weather", formdata).responseString { request, response, result ->
        //make a GET to http://httpbin.org/get and do something with response
        val (data, error) = result
        if (error == null) {
            //do something when success
            Log.i("weather", "Call complete the data received ->")
            Log.i("weather", data)
        } else {
            //error handling
            Log.e("weather", "Weather call error")
            error.printStackTrace()
        }
    }
    Log.i("weather", "Weather call done")
}