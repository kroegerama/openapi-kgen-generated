// NOTE: This file is auto generated. Do not edit the file manually!
// 
// Swagger Petstore
// Version 1.0.0
// 
// Spec License
//   MIT
// 
// Generated Fri, 31 Jan 2020 16:46:05 +0100
// Retrofit Kotlin Generator (version 1.0-SNAPSHOT) by kroegerama
//
package com.kroegerama.kgen

import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.listOf

object ApiBuildConfig {
    /**
     * Value of **OpenAPI.info.version**
     */
    const val API_VERSION: String = "1.0.0"

    /**
     * Value of **OpenAPI.info.title**
     */
    const val API_TITLE: String = "Swagger Petstore"

    /**
     * Value of **OpenAPI.info.description**
     */
    val API_DESCRIPTION: String? = null

    /**
     * Time of code generation. Formatted as **RFC 1123** date time.
     */
    const val GEN_FORMATTED: String = "Fri, 31 Jan 2020 16:46:05 +0100"

    /**
     * Time of code generation. **Unix timestamp** in seconds since 1970-01-01T00:00:00Z.
     */
    const val GEN_TIMESTAMP: Long = 1580485565
}

val serverList: List<String> = listOf("http://petstore.swagger.io/v1")
