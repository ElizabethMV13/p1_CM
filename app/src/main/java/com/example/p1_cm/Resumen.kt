package com.example.p1_cm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Resumen : AppCompatActivity() {

    lateinit var textView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        textView= findViewById(R.id.textSalida)

        textView.text = intent.getParcelableExtra<DataForm>("DataForm").toString()


        val btnBack: Button = findViewById(R.id.buttonBack)

        btnBack.setOnClickListener {

            val intentBack = Intent(this, MainActivity::class.java)
            startActivity(intentBack)
        }

    }
}
