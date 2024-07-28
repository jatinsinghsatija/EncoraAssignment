package com.example.encoraassignment.network

import com.example.encoraassignment.model.Feed
import com.google.gson.JsonObject
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.await

object APIHolder {
    var apiService = RetrofitUtil.createBaseApiService()
    suspend fun demoAPI(): UseCaseResult<Feed> {
        return try {
            val result = RetrofitUrlExtensions.demoData.getAPIService().await()
            UseCaseResult.Success(result)
        } catch (e: Exception) {
            UseCaseResult.Error(e)
        }
    }

    private fun String.getAPIService(): Call<Feed> {
        return apiService.commonGetAPI(
            url = this
        )

    }
}