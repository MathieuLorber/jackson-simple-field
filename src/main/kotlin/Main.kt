package org.example

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule

data class SimpleDataClass(val username: String)

fun main() {
    val objectMapper = ObjectMapper().apply {
        registerKotlinModule()
    }

    val json = objectMapper.writeValueAsString(SimpleDataClass("test"))
    require(json == """{"username":"test"}""")
    objectMapper.readValue(json, SimpleDataClass::class.java)
}
