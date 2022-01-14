package com.example.mytranlatorapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class TranslateEntity(
    val originalTextEntity: String,
    val translatedTextEntity: String,
    val languageEntity: String,
    //нужен для идентификации в room
    @PrimaryKey(autoGenerate = true) val id: Int = 0
    )

