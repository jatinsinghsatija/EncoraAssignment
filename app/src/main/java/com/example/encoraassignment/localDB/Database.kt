package com.example.encoraassignment.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.encoraassignment.model.Entry


@Database(entities = [SongsModel::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {
    abstract fun dao(): Dao?
}