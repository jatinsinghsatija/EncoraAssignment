package com.example.encoraassignment.view.activity

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.encoraassignment.listeners.CallbackListener
import com.example.encoraassignment.localDB.SongsModel
import com.example.encoraassignment.model.Entry
import com.example.encoraassignment.model.Feed
import com.example.encoraassignment.network.APICalls
import com.example.encoraassignment.utility.DialogManager
import com.example.encoraassignment.utility.Utility
import com.squareup.moshi.internal.Util
import java.lang.Exception

class MainViewModel : ViewModel() {

    private val title = MutableLiveData<String>()
    private val list = MutableLiveData<List<SongsModel>>()
    val _list: LiveData<List<SongsModel>>
        get() = list
    val _title: LiveData<String>
        get() = title

    fun hitAPI() {
        APICalls.demoAPI(object : CallbackListener {
            override fun demoAPISuccess(result: List<SongsModel>?) {
                DialogManager.hideDialog()
                result?.let {
                    list.value = it
                }
            }


            override fun demoAPIFailure(exp: Exception) {
                DialogManager.hideDialog()
                Utility.getTopActivity()?.let {
                    Toast.makeText(it, exp.localizedMessage ?: "", Toast.LENGTH_SHORT).show()
                }
            }
        })

    }
}