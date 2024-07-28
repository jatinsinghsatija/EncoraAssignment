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
import com.example.encoraassignment.utility.MediaPlay
import com.example.encoraassignment.utility.MediaPlay.Companion.play
import com.example.encoraassignment.utility.Utility.openUrl

import com.squareup.picasso.Picasso

class DetailFragment(val song: SongsModel?) : Fragment() {
    lateinit var binding: ActivityDetailBinding
    var played = false


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.activity_detail, container, false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        setData()
        return binding.root
    }

    fun setData() {
        binding.title.text = song?.name ?: ""
        binding.artists.text="Artists: ${song?.artist?:""}"
        binding.price.text="Price: $${song?.amount?:""}"
        binding.copyright.text=song?.rights?:""
        Picasso.get().load(song?.image170 ?: "").into(binding.image)
        onClicks()
    }

    fun onClicks(){
        binding.back.setOnClickListener {
            activity?.onBackPressed()
        }

        binding.title.setOnClickListener {
            song?.songId?.openUrl()
        }
        binding.playStop.setOnClickListener {
            if (played) {
                binding.playStop.setImageResource(android.R.drawable.ic_media_play)
                played = false
                MediaPlay.stop()
            } else {
                binding.playStop.setImageResource(android.R.drawable.ic_media_pause)
                played = true
                song?.audioRef.play()
            }
        }
    }
    override fun onDetach() {

        super.onDetach()
        MediaPlay.stop()
    }
}