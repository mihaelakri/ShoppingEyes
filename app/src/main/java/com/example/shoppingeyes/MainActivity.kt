package com.example.shoppingeyes

import android.animation.Animator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.*
import android.widget.Toast
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

        setContentView(R.layout.activity_main)

        tts = TextToSpeech(this,this)


        val iHomeScreen = Intent(this, HomeScreen::class.java)

        // LOGO animation

        val anim_logo = loading_logo.animate()
                .setDuration(2000)
                .translationX(750f)
        anim_logo.start()

        anim_logo.setListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {
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
            tts!!.speak("Shopping eyes", TextToSpeech.QUEUE_FLUSH, null, "")
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                Toast.makeText(this, "Language specified not supported", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        if(tts != null){
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }
}