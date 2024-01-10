package com.tatry.harryretrofit.data.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.tatry.harryretrofit.data.network.dto.CharacterDto
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://harry-potter-api-en.onrender.com"

// funs from CharacterRepository
interface SearchCharactersApi{

    @GET("/characters")
    suspend fun getCharacters(): List<CharacterDto>

//    // ?id=1
//    @GET("/characters")
//    suspend fun getCharacterById(@Query("id") id: Int = 1): CharacterDto

    @GET("/characters/{id}")
    suspend fun getCharacterByIdPath(@Path("id") id: Int): CharacterDto
}

object RetrofitInstance{

    private val okHttpClient = OkHttpClient.Builder()
        .readTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor())
        .build()

//    private val moshi = Moshi.Builder()
//        .add(KotlinJsonAdapterFactory())
//        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
//        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(okHttpClient)
        .build()
    val searchCharactersApi: SearchCharactersApi = retrofit.create(SearchCharactersApi::class.java)
}