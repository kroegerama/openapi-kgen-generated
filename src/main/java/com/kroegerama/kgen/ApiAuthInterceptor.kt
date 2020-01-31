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

import com.kroegerama.kgen.ApiAuthInterceptor
import com.kroegerama.kgen.ApiAuthInterceptor.AuthPosition.Header
import com.kroegerama.kgen.ApiAuthInterceptor.AuthPosition.Query
import kotlin.String
import kotlin.collections.MutableMap
import kotlin.collections.mutableMapOf
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

object ApiAuthInterceptor : Interceptor {
    private val authMap: MutableMap<String, AuthInfo> = mutableMapOf()

    const val AUTH_INFO_HEADER: String = "X-OpenAPI-Auth-Name"

    fun clearAllAuth() = authMap.clear()

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val authHeaders = request.headers(AUTH_INFO_HEADER)
        if (authHeaders.isEmpty()) {
            return chain.proceed(request)
        }

        val newRequest = request.newBuilder().run {
            removeHeader(AUTH_INFO_HEADER)
            val required = authMap.filter { it.key in authHeaders }.values
            required.forEach { (position, paramName, paramValue) ->
                when (position) {
                    Header -> addHeader(paramName, paramValue)
                    Query -> url(
                        request.url.newBuilder()
                            .addQueryParameter(paramName, paramValue)
                            .build()
                    )
                }
            }
            build()
        }
        return chain.proceed(newRequest)
    }

    private data class AuthInfo(
        val position: AuthPosition,
        val paramName: String,
        val paramValue: String
    ) {
        companion object {
            fun basic(username: String, password: String) = AuthInfo(Header, "Authorization",
                    Credentials.basic(username, password))

            fun bearer(token: String) = AuthInfo(Header, "Authorization", """Bearer $token""")

            fun header(name: String, value: String) = AuthInfo(Header, name, value)

            fun query(name: String, value: String) = AuthInfo(Query, name, value)
        }
    }

    private enum class AuthPosition {
        Header,

        Query
    }
}
