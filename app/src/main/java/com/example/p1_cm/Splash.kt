package com.example.p1_cm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.p1_cm.databinding.ActivitySplashBinding
import kotlin.concurrent.thread

class Splash: AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        thread {
            Thread.sleep(3000)
            val  intent: Intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
}


