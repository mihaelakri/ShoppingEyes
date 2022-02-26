package com.example.shoppingeyes

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.*
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.shoppingeyes.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener{
    private lateinit var binding: ActivityMainBinding
    private var tts: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        val name = "Shopping eyes"
        setContentView(R.layout.activity_main)

        tts = TextToSpeech(this,this)

        val iHomeScreen = Intent(this, HomeScreen::class.java)

        val anim_logo = loading_logo.animate()
                .setDuration(2000)
                .translationX(750f)


        anim_logo.start()
        anim_logo.setListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {
                tts!!.speak(name, TextToSpeech.QUEUE_FLUSH, null)
                tts!!.shutdown()
            }

            override fun onAnimationEnd(animation: Animator?) {
                startActivity(iHomeScreen)
            }

            override fun onAnimationCancel(animation: Animator?) {
                TODO("Not yet implemented")
            }

            override fun onAnimationRepeat(animation: Animator?) {
                TODO("Not yet implemented")
            }
        })
    }
    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            var result = tts!!.setLanguage(Locale.US)
        }
    }
}