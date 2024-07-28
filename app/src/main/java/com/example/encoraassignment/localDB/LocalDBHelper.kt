package com.example.encoraassignment.localDB

import com.example.encoraassignment.utility.Utility

class LocalDBHelper private constructor() {
    companion object{
    private var db: SongsDatabaseClient? = null
    private var entryDao: Dao? = null
    private fun getInstance() {

        Utility.getTopActivity()?.let {
            if (db == null) {
                db = SongsDatabaseClient.getInstance(it.applicationContext)
            }
            if (entryDao == null) {
                entryDao = db?.getSongsAppDatabase()?.dao()
            }
        }
    }

    fun getDao(): Dao? {
        getInstance()
        return entryDao
    }
}
}