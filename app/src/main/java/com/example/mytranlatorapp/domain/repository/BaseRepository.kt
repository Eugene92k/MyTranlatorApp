package com.example.mytranlatorapp.domain.repository

import com.example.mytranlatorapp.data.model.Resource
import retrofit2.Response

abstract class BaseRepository {
    protected suspend fun <T : Any> safeApiCall(
        call: suspend () -> Response<T>
    ): Resource<T> {
        return try {
            val response = call()
            if (response.isSuccessful) Resource.Success(response.body()!!)
            else Resource.Error(response.errorBody()?.string().toString())
        } catch (e: Exception) {
            println(e.message)
            Resource.Error(message = e.message ?: "unknown error")
        }
    }
}