package com.example.mytranlatorapp.data.api

import com.example.mytranlatorapp.RAPID_HOST_KEY
import com.example.mytranlatorapp.RAPID_HOST_VALUE
import com.example.mytranlatorapp.RAPID_KEY
import com.example.mytranlatorapp.RAPID_KEY_VALUE
import com.example.mytranlatorapp.data.model.TranslatorResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface ApiTranslator {
    @GET("translate")
    suspend fun getTranslate(
        @Header(RAPID_KEY) rapid: String = RAPID_KEY_VALUE,
        @Header(RAPID_HOST_KEY) rapidHost: String = RAPID_HOST_VALUE,
        @Query("text") text: String,
        @Query("to") to: String
    ): Response<TranslatorResponse>
}