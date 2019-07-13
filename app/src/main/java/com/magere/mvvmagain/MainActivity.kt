package com.magere.mvvmagain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.RoomDatabase
import com.magere.mvvmagain.data.room.EntityWordsData
import com.magere.mvvmagain.data.room.WordsDataBase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = WordsDataBase.getInstance(this)
        val wordsDataDao = db?.wordsDataDao()

        GlobalScope.launch(Dispatchers.IO) {
            wordsDataDao?.insert(EntityWordsData(1, "Hello", "Привет", null, null))
            textView.text = wordsDataDao?.getAllWords().toString()
        }

    }
}
