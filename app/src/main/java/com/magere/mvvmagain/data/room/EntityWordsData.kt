package com.magere.mvvmagain.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wordsData")
data class EntityWordsData(
    @PrimaryKey(autoGenerate = true) var id: Long?,
    @ColumnInfo(name = "word") var word: String,
    @ColumnInfo(name = "translate") var translate: String?,
    @ColumnInfo(name = "example") var example: String?,
    @ColumnInfo(name = "exampleTranslate") var exampleTranslate: String?
) {
    constructor() : this(
        null,
        "",
        "",
        "",
        ""
    )
}