package com.example.encoraassignment.utility

import com.example.encoraassignment.view.dialogs.LoadingDialogFragment

object DialogManager {
     var loader:LoadingDialogFragment?=null
    fun showDialog(){
       hideDialog()
        loader= LoadingDialogFragment()
        loader?.dialog?.show()
    }

    fun hideDialog(){
        loader?.dialog?.hide()
        loader=null
    }
}