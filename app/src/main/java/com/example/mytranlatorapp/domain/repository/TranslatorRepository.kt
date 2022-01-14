package com.example.mytranlatorapp.domain.repository


interface TranslatorRepository {

    suspend fun getTranslate(
        text: String,
        to: String
    ): String
}