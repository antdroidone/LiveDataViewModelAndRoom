package com.example.livedataviewmodelandroom.room

import androidx.lifecycle.LiveData

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class WordRepository(private val wordDao: WordDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allWordsASC: LiveData<List<Word>> = wordDao.getAlphabetizedWordsASC()
    val allWordsDESC: LiveData<List<Word>> = wordDao.getAlphabetizedWordsDESC()

    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}