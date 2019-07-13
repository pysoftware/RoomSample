package com.magere.mvvmagain.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface WordsDataDao {

    @Query("SELECT * FROM wordsData")
    fun getAllWords(): List<EntityWordsData>

    @Insert(onConflict = REPLACE)
    fun insert(entityWordsData: EntityWordsData)

    @Query("DELETE from wordsData")
    fun deleteAll()

}