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

import java.lang.Class
import kotlin.Any
import kotlin.collections.MutableMap
import kotlin.collections.mutableMapOf
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create

interface ApiDecorator {
    fun OkHttpClient.Builder.decorate()

    fun Retrofit.Builder.decorate()
}

object ApiHolder {
    var decorator: ApiDecorator? = null
        set(value) {
            field = value
            invalidate()
        }

    private var currentClient: OkHttpClient? = null

    private var currentRetrofit: Retrofit? = null

    val client: OkHttpClient
        get() = currentClient ?: createClient().also { currentClient = it }

    val retrofit: Retrofit
        get() = currentRetrofit ?: createRetrofit().also { currentRetrofit = it }

    private val apiHolder: MutableMap<Class<*>, Any> = mutableMapOf()

    fun invalidate() {
        currentClient = null
        currentRetrofit = null
    }

    private fun createClient() = OkHttpClient.Builder().run {
        addInterceptor(ApiAuthInterceptor)
        decorator?.apply { decorate() }
        build()
    }

    private fun createRetrofit() = Retrofit.Builder().run {
        baseUrl(serverList.first())
        client(client)
        addConverterFactory(ScalarsConverterFactory.create())
        addConverterFactory(MoshiConverterFactory.create())
        decorator?.apply { decorate() }
        build()
    }

    internal inline fun <reified T : Any> getApi(): T = apiHolder.getOrPut(T::class.java) {
        retrofit.create<T>()
    } as T
}
