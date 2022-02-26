package com.example.shoppingeyes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class HomeScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        supportActionBar?.hide()

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



}