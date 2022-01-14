package com.example.mytranlatorapp.data.db

import androidx.room.*
import com.example.mytranlatorapp.data.model.TranslateEntity

@Dao
interface TranslateDao {
    @Query(
        "SELECT * FROM translateEntity " +
                "WHERE originalTextEntity = :originalTextEntity " +
                "AND languageEntity = :languageEntity"
    )
    suspend fun getByOriginal(originalTextEntity: String, languageEntity: String): TranslateEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: TranslateEntity)
}