package com.magere.mvvmagain.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [EntityWordsData::class], version = 1)
abstract class WordsDataBase : RoomDatabase() {

    abstract fun wordsDataDao(): WordsDataDao

    companion object {
        private var INSTANCE: WordsDataBase? = null

        fun getInstance(context: Context): WordsDataBase? {
            if (INSTANCE == null) {
                synchronized(WordsDataBase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        WordsDataBase::class.java, "words.db"
                    ).build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}