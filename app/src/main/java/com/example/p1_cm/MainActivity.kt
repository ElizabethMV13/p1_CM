package com.example.p1_cm

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var mp: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mp = MediaPlayer.create(this,R.raw.ringtonesamelie)
        mp.start()

        val btn1: Button = findViewById(R.id.button1)

        btn1.setOnClickListener{

            val  intent1: Intent = Intent(this,QuienesSomos::class.java)
            startActivity(intent1)
        }

        val btn2: Button = findViewById(R.id.button2)

        btn2.setOnClickListener{

            val  intent2: Intent = Intent(this,FormulationMain::class.java)
            startActivity(intent2)
        }

        val btn3: Button = findViewById(R.id.button3)

        btn3.setOnClickListener{

            val  intent3: Intent = Intent(this,VerCarreras::class.java)
            startActivity(intent3)
        }

    }

    override fun onStart() {
        super.onStart()
            mp.start()
    }


    override fun onPause() {
        super.onPause()
        mp.pause()
    }

    override fun onStop() {
        super.onStop()
        mp.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mp.pause()
        mp.start()
    }

    override fun onRestart() {
        super.onRestart()
        mp.start()
    }
}