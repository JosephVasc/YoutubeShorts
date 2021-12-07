package com.example.youtubeshorts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import android.net.Uri
import android.net.Uri.*
import android.os.Environment
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class HomeFeed: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_feed)
        videoPlayer()
    }
    fun videoPlayer(){
        val videoView = findViewById<VideoView>(R.id.videoView)
        //Creating MediaController
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        //specify the location of media file
        val uri:Uri = parse("android.resource://" + getPackageName() +"/"+R.raw.video1)
        //Setting MediaController and URI, then starting the videoView
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()

        videoView.start()
    }

}