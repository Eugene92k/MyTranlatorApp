package com.example.mytranlatorapp.data.model

data class TranslatedText(
    val ru: String? = null,
    val de: String? = null,
    val en: String? = null
) {
    fun getByLanguage(language: String): String {
        val map = mapOf(
            "ru" to ru,
            "en" to en,
            "de" to de
        )
        return map[language] ?: "Ошибка! Не удалось перевести."
    }
}