package com.example.a24012011140_mad_practical6

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        val alarmImage = findViewById<ImageView>(R.id.ivAlarm)

        alarmImage.setBackgroundResource(R.drawable.alarm_frame_anim)

        val alarmAnimation = alarmImage.background as AnimationDrawable
        alarmAnimation.start()

        val heart = findViewById<ImageView>(R.id.ivHeart)

        heart.setBackgroundResource(R.drawable.ic_heart_outline)

        val heartAnimation = heart.background as AnimationDrawable
        heartAnimation.start()
    }
}