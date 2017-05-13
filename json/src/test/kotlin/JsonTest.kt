import me.ddevil.json.json
import me.ddevil.json.jsonArray
import me.ddevil.json.parse.JsonParser
import me.ddevil.util.getResource
import org.junit.Test
import java.io.File
import java.io.FileReader

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

    @Test
    fun parse() {
        val jsonTest = getResource("testJson.json")
        val json = FileReader(File(jsonTest.toURI())).readText()
        println(json)
        println(JsonParser().parseObject(json).toJson())
    }
}