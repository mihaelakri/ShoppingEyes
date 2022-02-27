package com.example.shoppingeyes

import android.content.Context
import android.content.SharedPreferences

class SharedPrefs(context: Context) {
    private var sharedPrefFile = "shared_prefs"
    private var prefs: SharedPreferences = context.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
    private var editor: SharedPreferences.Editor = prefs.edit()
    var con: Context? = null

    var PRIVATE_MODE = 0
    private val PREF_NAME = "settings"
    val THEME = "theme"
    val FONT_SIZE = "font_size"
    val LETTER_SPACING = "letter_spacing"
    val CAMERA_FLASH = "camera_flash"
    val TEXT_TO_SPEECH = "tts"

    fun SharedPrefs(context: Context) {
        this.con = context
        prefs = con!!.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = prefs.edit()
    }

    fun changeTheme(theme: String){
        editor.putString(THEME, theme)
        editor.commit()
    }

    fun cameraFlash(cam: Boolean){
        editor.putString(CAMERA_FLASH, cam.toString())
        editor.commit()
    }

    fun sound(sound: Boolean){
        editor.putString(TEXT_TO_SPEECH, sound.toString())
        editor.commit()
    }


}