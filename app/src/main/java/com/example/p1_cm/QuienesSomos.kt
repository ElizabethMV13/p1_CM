package com.example.p1_cm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.graphics.BitmapFactory

class QuienesSomos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quienes_somos)

        val btnBack: Button = findViewById(R.id.buttonBack)

        btnBack.setOnClickListener{

            val  intentBack: Intent = Intent(this,MainActivity::class.java)
            startActivity(intentBack)
        }

    }

}