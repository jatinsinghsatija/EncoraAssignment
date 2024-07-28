package com.example.encoraassignment.utility

import android.media.MediaPlayer

class MediaPlay private constructor(){

    companion object{
        private var mediaPlayer: MediaPlayer? = null

        fun String?.play(){
            val url=this
            mediaPlayer?.release()

            mediaPlayer = MediaPlayer().apply {
                setDataSource(url)
                setOnPreparedListener { mp ->
                    mp.start() // Start playback once media is prepared
                }
                setOnErrorListener { mp, what, extra ->
                    mp.stop()
                    mp.release()
                    // Handle errors
                    true
                }
                prepareAsync() // Prepare the media player asynchronously
            }

        }

        fun stop(){
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer=null
        }
    }
}