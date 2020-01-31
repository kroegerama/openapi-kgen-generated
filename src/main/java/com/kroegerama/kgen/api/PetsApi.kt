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
package com.kroegerama.kgen.api

import com.kroegerama.kgen.ApiHolder
import com.kroegerama.kgen.models.Pet
import com.kroegerama.kgen.models.Pets
import kotlin.Int
import kotlin.String
import kotlin.Unit
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface PetsApi {
    @GET("pets")
    suspend fun __listPets(@Query("limit") limit: Int?): Response<Pets>

    @POST("pets")
    suspend fun __createPets()

    @GET("pets/{petId}")
    suspend fun __showPetById(@Path("petId") petId: String): Response<Pet>

    companion object {
        /**
         * @param limit How many items to return at one time (max 100)
         * @return A paged array of pets
         */
        suspend fun listPets(limit: Int? = null): Response<Pets> =
                ApiHolder.getApi<PetsApi>().__listPets(limit)

        /**
         * @return Null response
         */
        suspend fun createPets(): Unit = ApiHolder.getApi<PetsApi>().__createPets()

        /**
         * @param petId The id of the pet to retrieve
         * @return Expected response to a valid request
         */
        suspend fun showPetById(petId: String): Response<Pet> =
                ApiHolder.getApi<PetsApi>().__showPetById(petId)
    }
}
