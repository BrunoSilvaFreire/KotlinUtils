
import me.ddevil.json.json
import me.ddevil.json.jsonArray
import org.junit.Test

class JsonTest {
    @Test
    fun typeSafeBuilder() {
        val name = json {
            this["name"] = "君の名は"
            this["isAwesome"] = true
        }
        val json = json {
            this["movie"] = name
            this["integer"] = 2
            this["string"] = "halp"
            this["nullable"] = null
            this["array"] = jsonArray <Any> {
                add(2)
                add(1)
                add("Hello")
            }
        }
        println(json.toJson())
    }
}