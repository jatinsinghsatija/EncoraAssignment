package com.example.encoraassignment.view.fragments

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.encoraassignment.R
import com.example.encoraassignment.databinding.ActivityDetailBinding
import com.example.encoraassignment.localDB.SongsModel

import com.squareup.picasso.Picasso

class DetailFragment(val song:SongsModel?) : Fragment() {
    lateinit var binding: ActivityDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.activity_detail, container, false
        )
        binding.lifecycleOwner=viewLifecycleOwner
        setData()
        return binding.root
    }

    fun setData() {
        binding.title.text=song?.name?:""
       binding.description.text= Html.fromHtml(song?.content?:"", Html.FROM_HTML_MODE_LEGACY)
        Picasso.get().load(song?.image170?:"").into(binding.image)
    }
}