package com.example.encoraassignment.localDB

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.encoraassignment.model.Entry


@Dao
interface Dao {
    @Query("SELECT * FROM SongsModel")
    fun getAllEntries(): List<SongsModel>

    @Insert
    fun insert(task: SongsModel)

    @Delete
    fun delete(task: SongsModel)

    @Update
    fun update(task: SongsModel)

    @Query("DELETE FROM SongsModel")
    fun deleteAll()
}