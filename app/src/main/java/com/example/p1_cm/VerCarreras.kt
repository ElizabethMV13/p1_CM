package com.example.p1_cm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class VerCarreras : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_carreras)
        initRecyclerView()

        val btnBack: Button = findViewById(R.id.buttonBack)

        btnBack.setOnClickListener{

            val  intentBack: Intent = Intent(this,MainActivity::class.java)
            startActivity(intentBack)
        }
    }

    private fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CustomAdapter(EngineeringProvider.listIng)
    }
}