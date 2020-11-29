package com.userdetail.demo.data

import com.userdetail.demo.data.response.UserDetail
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("users")
    suspend fun getListData(@Query("page") pageNumber: Int): Response<UserDetail>

    companion object {

        private val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        fun getApiService() = Retrofit.Builder()
            .baseUrl("https://gorest.co.in/public-api/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(APIService::class.java)
    }
}
