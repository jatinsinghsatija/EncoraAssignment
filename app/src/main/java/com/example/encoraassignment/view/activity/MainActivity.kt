package com.example.encoraassignment.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.encoraassignment.R
import com.example.encoraassignment.databinding.ActivityMainBinding
import com.example.encoraassignment.utility.Utility.goToListFrag

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var factory:ViewModelFactory
    lateinit var model: MainViewModel
    var frameID=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setData()
    }

    fun setData(){
        frameID=binding.fragmentArea.id
        factory= ViewModelFactory()
        model = ViewModelProvider(this,factory).get(MainViewModel::class.java)
        goToListFrag()
    }

    fun getVisibleFragment(): Fragment? {
        supportFragmentManager
        supportFragmentManager.fragments.forEach {
            if (it.isVisible) {
                return it
            }
        }
        return null
    }
}