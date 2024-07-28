package com.example.encoraassignment.network

import com.example.encoraassignment.listeners.CallbackListener
import com.example.encoraassignment.localDB.Database
import com.example.encoraassignment.localDB.LocalDBHelper
import com.example.encoraassignment.localDB.SongsDatabaseClient
import com.example.encoraassignment.utility.DialogManager
import com.example.encoraassignment.utility.GlobalCache
import com.example.encoraassignment.utility.Utility
import com.example.encoraassignment.utility.Utility.getFirst20
import com.example.encoraassignment.utility.Utility.toSongsModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object APICalls {
    private var globalScope: Job? = null
    fun demoAPI(listener: CallbackListener) {
        DialogManager.showDialog()

        globalScope = CoroutineScope(Dispatchers.IO).launch {
            val data = LocalDBHelper.getDao()?.getAllEntries()
            if (data.isNullOrEmpty()) {
                APIHolder.apiService =
                    RetrofitUtil.createBaseApiService(baseUrl = RetrofitUtil.BASE_URL)
                when (val result = APIHolder.demoAPI()) {
                    is UseCaseResult.Success -> {
                        result.data.entries?.getFirst20()?.forEach {
                            LocalDBHelper.getDao()?.insert(it.toSongsModel())
                        }
                        withContext(Dispatchers.Main) {
                            listener.demoAPISuccess(
                                result.data.entries.getFirst20().toSongsModel()
                            )

                        }
                    }

                    is UseCaseResult.Error -> {
                        withContext(Dispatchers.Main) {
                            listener.demoAPIFailure(result.exception)
                        }
                    }

                    else -> UseCaseResult.Empty
                }
            } else {
                withContext(Dispatchers.Main) {
                    listener.demoAPISuccess(data)
                }
            }
        }
    }
}