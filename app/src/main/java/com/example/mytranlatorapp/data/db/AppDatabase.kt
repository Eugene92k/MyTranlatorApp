package com.example.mytranlatorapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mytranlatorapp.data.model.TranslateEntity


@Database(entities = [TranslateEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun translateDao(): TranslateDao

companion object {
    @Volatile
    private var INSTANCE: AppDatabase? = null

   private fun getDatabase(context: Context): AppDatabase = INSTANCE ?: synchronized(this){
        val instance = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase ::class.java,
            "train-db"
        ).build()
        INSTANCE = instance
        instance
    }

    fun getTranslateDao(context: Context): TranslateDao {
        return getDatabase(context).translateDao()
    }
}
}