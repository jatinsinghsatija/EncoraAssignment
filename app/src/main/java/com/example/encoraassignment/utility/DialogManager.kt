package com.example.encoraassignment.utility

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.Window
import android.widget.FrameLayout
import com.example.encoraassignment.R
import com.example.encoraassignment.view.dialogs.LoadingDialogFragment

object DialogManager {
     var loader: Dialog?=null


    fun hideDialog(){
        loader?.hide()
        loader=null
    }

    fun showDialog(){
        Utility.getTopActivity()?.let {
            loader = Dialog(it)
            val view=it.layoutInflater.inflate(R.layout.loading_dialog,null)
            loader?.requestWindowFeature(Window.FEATURE_NO_TITLE)
            loader?.setCancelable(false)
            loader?.setContentView(view)
            loader?.show()
        }

    }
}