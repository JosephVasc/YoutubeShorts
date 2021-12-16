package com.example.youtubeshorts

import android.os.Bundle
import android.net.Uri
import android.net.Uri.*
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat


class HomeFeed: AppCompatActivity()  {

    private lateinit var detector: GestureDetectorCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_feed)
        videoPlayer()
        detector = GestureDetectorCompat(this, swipedownListener())
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (detector.onTouchEvent(event)){
            true
        }else{
            super.onTouchEvent(event)
        }
        return super.onTouchEvent(event)
    }

    inner class swipedownListener :GestureDetector.SimpleOnGestureListener(){
        private val Swipe_Threshold = 100
        private val Swipe_Velocity_Threshold = 100
        override fun onFling(
            downEvent: MotionEvent?,
            moveEvent: MotionEvent?,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            var diffX = moveEvent?.x?.minus(downEvent!!.x) ?: 0.0F
            var diffY = moveEvent?.y?.minus(downEvent!!.y) ?: 0.0F

            return if (Math.abs(diffX)> Math.abs(diffY))
            {
                //this is a left or right swipe
                if (Math.abs(diffX) > Swipe_Threshold && Math.abs(velocityX) > Swipe_Velocity_Threshold)
                {
                    if (diffX>0)
                    {
                        //right swipe
                        this@HomeFeed.onSwipeRight()
                    }else
                    {
                        this@HomeFeed.onSwipeLeft()
                        //left swipe
                    }
                    true

                }else{
                    super.onFling(downEvent, moveEvent, velocityX, velocityY)
                }
            }
            else
            {
                if (Math.abs(diffY) > Swipe_Threshold && Math.abs(velocityY)>Swipe_Velocity_Threshold)
                {
                    if (diffY>0)
                    {
                        this@HomeFeed.onSwipeTop()
                    }else{
                        this@HomeFeed.onSwipeBottom()
                    }
                    true
                }else{
                    super.onFling(downEvent, moveEvent, velocityX, velocityY)
                }
            }
        }
    }

    private fun onSwipeLeft() {
        TODO("Not yet implemented")
    }

    private fun onSwipeRight() {
        TODO("Not yet implemented")
    }

    private fun onSwipeBottom() {
        videoPlayer()
    }

    private fun onSwipeTop() {
        videoPlayer()
    }


    fun videoPlayer(){
        val videoView = findViewById<VideoView>(R.id.videoView)
        //Creating MediaController
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        //specify the location of media file
        var uri:Uri = parse("android.resource://" + getPackageName() +"/"+R.raw.video1)
        val random = (1..3).shuffled().last()
        when (random){
            1 -> uri = parse("android.resource://" + getPackageName() +"/"+R.raw.video1)
            2 -> uri = parse("android.resource://" + getPackageName() +"/"+R.raw.video2)
            3 -> uri = parse("android.resource://" + getPackageName() +"/"+R.raw.video3)
        }
        //Setting MediaController and URI, then starting the videoView
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()

        videoView.start()

    }
}