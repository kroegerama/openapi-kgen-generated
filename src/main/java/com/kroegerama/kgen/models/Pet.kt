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
package com.kroegerama.kgen.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlin.Long
import kotlin.String

@JsonClass(generateAdapter = true)
data class Pet(
    @Json(name = "id")
    val id: Long,
    @Json(name = "name")
    val name: String,
    @Json(name = "tag")
    val tag: String? = null
)
