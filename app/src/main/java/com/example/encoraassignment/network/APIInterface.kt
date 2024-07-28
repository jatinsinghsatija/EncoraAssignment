package com.example.encoraassignment.network


import com.example.encoraassignment.model.Feed
import com.google.gson.JsonObject
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.*

interface APIInterface {

    @GET
    fun commonGetAPI(
        @Url url: String
    ): Call<Feed>

}