package com.example.mytranlatorapp.domain.repository

import android.content.Context
import com.example.mytranlatorapp.data.db.AppDatabase
import com.example.mytranlatorapp.data.db.TranslateDao
import com.example.mytranlatorapp.data.model.Resource
import com.example.mytranlatorapp.data.model.TranslateEntity
import com.example.mytranlatorapp.data.model.TranslatorResponse
import com.example.mytranlatorapp.data.network.Retrofit
import retrofit2.Response


class TranslateRepositoryImpl(context: Context) : BaseRepository(), TranslatorRepository {

    private val translateDao = AppDatabase.getTranslateDao(context)

    private suspend fun savedTranslateToDatabase(entity: TranslateEntity) {
        translateDao.insert(entity)
    }

    override suspend fun getTranslate(text: String, to: String): String {
        val cached = getTranslateFromDatabase(text, to)
        if (cached != null) return cached.translatedTextEntity
        return getTranslateFromNetwork(text, to)
    }

    private suspend fun getTranslateFromDatabase(text: String, to: String): TranslateEntity? {
        return translateDao.getByOriginal(text, to)
    }

    private suspend fun getTranslateFromNetwork(text: String, to: String): String {
        val api = Retrofit.translateApi
        val response = safeApiCall { api.getTranslate(text = text, to = to) }
        return when (response) {
            is Resource.Success ->{
                savedTranslateToDatabase(response.content.toEntity())
                response.content.translated_text.getByLanguage(to)
            }
            else -> {
                "Ошибка. Не удалось перевести"
            }
        }
    }
}
