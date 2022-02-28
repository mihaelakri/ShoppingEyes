package com.example.shoppingeyes

import android.os.Bundle
import android.view.View
import android.widget.Switch
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import com.example.shoppingeyes.databinding.ActivitySettingsBinding
import kotlinx.android.synthetic.main.activity_settings.*
import kotlinx.android.synthetic.main.activity_settings.view.*


class Settings : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding
    private lateinit var session: SharedPrefs


    override fun onCreate(savedInstanceState: Bundle?) {
        val v: View? = null
        //Initialize theme before super onCreate()

        session = SharedPrefs(this)
        val newTheme = session.getTheme()
        if(newTheme == "SecondTheme") {
            theme.applyStyle(R.style.SecondTheme_ShoppingEyes, true)
        }else{
            theme.applyStyle(R.style.Theme_ShoppingEyes, true)
        }

        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(R.layout.activity_settings)

        //First switch - HIGH CONTRAST
        val highContrast = findViewById<Switch>(R.id.highContrast)

        highContrast?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                session.changeTheme("SecondTheme")
                Toast.makeText(this, "SecondTheme", Toast.LENGTH_SHORT).show()

            } else {
                session.changeTheme("Theme")
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