package com.example.shoppingeyes

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import com.example.shoppingeyes.databinding.ActivityMainBinding
import com.example.shoppingeyes.databinding.ActivitySettingsBinding
import kotlinx.android.synthetic.main.activity_settings.view.*

class Settings : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding
    private lateinit var session: SharedPrefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(R.layout.activity_settings)

        session = SharedPrefs(this)

        val darkTheme = R.style.darkTheme_ShoppingEyes
        val lightTheme = R.style.Theme_ShoppingEyes

        //First switch - HIGH CONTRAST
        val highContrast = findViewById<Switch>(R.id.highContrast)


        highContrast?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                session.changeTheme("darkTheme")
                setTheme(darkTheme);

            } else {
                setTheme(lightTheme);
            }
        }

        //Second switch - CAMERA FLASH
        val cameraFlash = findViewById<Switch>(R.id.cameraFlash)

        /*cameraFlash?.setOnCheckedChangeListener({ _ , isChecked ->
            if (isChecked){
                // is on, do:
            }else{
                // is off, do:
            }
        })

        //Third switch - SOUND
        val sound = findViewById<Switch>(R.id.sound)

        sound?.setOnCheckedChangeListener({ _ , isChecked ->
            if (isChecked){
                // is on, do:
            }else{
                // is off, do:
            }
        })*/
    }
}