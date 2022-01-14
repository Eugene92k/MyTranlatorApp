package com.example.mytranlatorapp.data.model

import com.google.gson.annotations.SerializedName

data class TranslatorResponse(
    @SerializedName("from") val from: String,
    @SerializedName("original_text") val original_text: String,
    @SerializedName("status") val status: Int,
    @SerializedName("to") val to: String,
    @SerializedName("translated_characters") val translated_characters: Int,
    @SerializedName("translated_text") val translated_text: TranslatedText
) {
    fun toEntity(): TranslateEntity {
return TranslateEntity(original_text, translated_text.getByLanguage(to), to)
    }
}


