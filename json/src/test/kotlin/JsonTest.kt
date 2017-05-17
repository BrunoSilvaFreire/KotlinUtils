
import com.google.common.collect.ImmutableList
import me.ddevil.json.json
import me.ddevil.json.jsonArray
import me.ddevil.json.parse.JsonParser
import me.ddevil.json.toJsonObject
import me.ddevil.util.*
import org.junit.Test
import java.io.File
import java.io.FileReader
import java.util.*

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
            this["a"] = json {
                this["b"] = json {
                    this["c"] = "hello world"
                }
            }
        }
        println(json.toJson())
    }

    @Test
    fun mineTest() {
        println(createMap().toJsonObject().toJson())
    }

    @Test
    fun parse() {
        val jsonTest = getResource("testJson.json")
        val json = FileReader(File(jsonTest.toURI())).readText()
        println(json)
        println(JsonParser().parseObject(json).toJson())
    }

    fun createMap() = immutableStringAnyMapBuilder()
            .put(DEFAULT_NAME_IDENTIFIER, "mine")
            .put(DEFAULT_ALIAS_IDENTIFIER, "mina")
            .put(DEFAULT_DESCRIPTION_IDENTIFIER, listOf("oisjdoisq"))
            .put("materials", createCompositionMap())
            .build()

    val random = Random()
    private fun createCompositionMap(): ImmutableList<Map<String, Any>>? {
        val builder = immutableListBuilder<Map<String, Any>>()
        for (i in 0..random.nextInt(10)) {
            builder.add(createMaterial())
        }
        return builder.build()
    }

    private fun createMaterial() = immutableStringAnyMapBuilder()
            .put("percentage", random.nextDouble() * 100)
            .put("type", "GOLD_ORE").build()
}