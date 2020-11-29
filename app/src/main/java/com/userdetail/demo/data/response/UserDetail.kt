package com.userdetail.demo.data.response

import com.squareup.moshi.Json


data class Data (
    @Json(name="id") val id : Int,
    @Json(name="name") val name : String,
    @Json(name="email") val email : String,
    @Json(name="gender") val gender : String,
    @Json(name="status") val status : String,
    @Json(name="created_at") val created_at : String,
    @Json(name="updated_at") val updated_at : String
)

data class UserDetail (

    @Json(name="code") val code : Int,
    @Json(name="meta") val meta : Meta,
    @Json(name="data") val data : List<Data>
)

data class Meta (

    @Json(name = "pagination") val pagination : Pagination
)

data class Pagination (

    @Json(name="total") val total : Int,
    @Json(name="pages") val pages : Int,
    @Json(name="page") val page : Int,
    @Json(name = "limit") val limit : Int
)