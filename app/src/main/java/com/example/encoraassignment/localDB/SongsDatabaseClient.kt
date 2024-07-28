package com.example.encoraassignment.localDB

import android.content.Context
import androidx.room.Room


class SongsDatabaseClient private constructor(private val mCtx: Context) {
    //our app database object
    private val destinationAppDatabase: Database

    init {
        destinationAppDatabase =
            Room.databaseBuilder(mCtx, Database::class.java, "SongsDB").build()
    }

    fun getSongsAppDatabase(): Database {
        return destinationAppDatabase
    }

    companion object {
        private var mInstance: SongsDatabaseClient? = null
        @Synchronized
        fun getInstance(mCtx: Context): SongsDatabaseClient? {
            if (mInstance == null) {
                mInstance = SongsDatabaseClient(mCtx)
            }
            return mInstance
        }
    }
}