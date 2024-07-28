package com.example.encoraassignment.listeners

import com.example.encoraassignment.localDB.SongsModel
import com.example.encoraassignment.model.Entry
import com.example.encoraassignment.model.Feed
import java.lang.Exception

interface CallbackListener {

    fun demoAPISuccess(result: List<SongsModel>?) {}
    fun demoItemClick(item:SongsModel) {}
    fun demoAPIFailure(exp:Exception) {}
}