package com.example.shoppingeyes

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.Toast
import java.util.*

class HomeScreen : AppCompatActivity(), TextToSpeech.OnInitListener {
    private var tts: TextToSpeech? = null
    private lateinit var session: SharedPrefs

    override fun onCreate(savedInstanceState: Bundle?) {
        session = SharedPrefs(this)

        //Initialize theme before super onCreate()

        val newTheme = session.getTheme()
        Toast.makeText(this, newTheme, Toast.LENGTH_SHORT).show()
        if(newTheme == "SecondTheme") {
            theme.applyStyle(R.style.SecondTheme_ShoppingEyes, true)
        }else{
            theme.applyStyle(R.style.Theme_ShoppingEyes, true)
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        supportActionBar?.hide()

        tts = TextToSpeech(this,this)
    }

    fun readPrices(v: View){
        val iReadPrices = Intent(this, ReadPrices::class.java)
        startActivity(iReadPrices)
    }

    fun readBanknotes(v: View){
        val iReadBanknotes = Intent(this, ReadBanknotes::class.java)
        startActivity(iReadBanknotes)
    }

    fun toSettings(v: View){
        val iSettings = Intent(this, Settings::class.java)
        startActivity(iSettings)
    }

    fun toInformation(v: View){
        val iInformation = Intent(this, Information::class.java)
        startActivity(iInformation)
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            var result = tts!!.setLanguage(Locale.US)
            tts!!.speak("first button: read the prices", TextToSpeech.QUEUE_ADD, null, "")
            tts!!.speak("second button: Identify the banknotes", TextToSpeech.QUEUE_ADD, null, "")
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