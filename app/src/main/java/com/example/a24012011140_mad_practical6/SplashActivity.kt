package com.example.a24012011140_mad_practical6

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity(), Animation.AnimationListener {

    lateinit var guniframeanimation: AnimationDrawable
    lateinit var imgLogo: ImageView
    lateinit var gunianimation: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_splash)

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

        imgLogo = findViewById(R.id.imgLogo)

        imgLogo.setBackgroundResource(R.drawable.uvpce_animation_list)

        guniframeanimation = imgLogo.background as AnimationDrawable

        gunianimation = AnimationUtils.loadAnimation(
            this,
            R.anim.twinanimation
        )

        gunianimation.setAnimationListener(this)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)

        if (hasFocus) {
            guniframeanimation.start()
            imgLogo.startAnimation(gunianimation)
        } else {
            guniframeanimation.stop()
        }
    }

    override fun onAnimationEnd(animation: Animation?) {
        Intent(this, MainActivity::class.java).also {
            startActivity(it)
        }
    }

    override fun onAnimationRepeat(animation: Animation?) {
    }

    override fun onAnimationStart(animation: Animation?) {
    }
}