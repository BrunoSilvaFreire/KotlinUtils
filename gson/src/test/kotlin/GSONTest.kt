import com.google.gson.Gson
import me.ddevil.util.gson.asMap
import me.ddevil.util.vector.DoubleVector3
import org.junit.Test

class GSONTest{
    @Test
    fun vector() {
        val json = Gson().toJsonTree(DoubleVector3(23.2, 52.11, 342.5))
        println(json.toString())
        val map = json.asJsonObject.asMap()
        println(map)
        for ((key, value) in map){
            println("$key=$value")
        }
    }
}