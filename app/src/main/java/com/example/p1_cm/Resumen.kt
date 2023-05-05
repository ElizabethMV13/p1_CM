package com.example.p1_cm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class Resumen : AppCompatActivity() {

    lateinit var textView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        textView= findViewById(R.id.textSalida)
        val ingPhoto = findViewById<ImageView>(R.id.carreraForm)

        var formatoSalida: String = """"""

        var dataForm = intent.getParcelableExtra<DataForm>("DataForm")

        formatoSalida = formatoSalida + getString(R.string.salida) + " \n "
        formatoSalida = formatoSalida + getString(R.string.bodyText) + " " + dataForm?.nombreCompleto.toString() + "\n "
        formatoSalida = formatoSalida + getString(R.string.bodyText1) + " " + dataForm?.edad.toString() + " " + getString(R.string.bodyText2) + "\n "
        formatoSalida = formatoSalida + getString(R.string.bodyText3) + " " + dataForm?.signoZodiacal.toString() + "\n "
        formatoSalida = formatoSalida + getString(R.string.bodyText4) + " " + dataForm?.signoChino.toString() + " " + getString(R.string.from) + " " + dataForm?.elemento.toString()  + "\n "
        formatoSalida = formatoSalida + getString(R.string.bodyText5) + " " + dataForm?.email.toString() + "\n "
        formatoSalida = formatoSalida + getString(R.string.bodyText6) + " " + dataForm?.numCuenta.toString() + "\n "
        formatoSalida = formatoSalida + getString(R.string.bodyText7) + " " + dataForm?.carrera.toString() + "\n "

        Glide.with(ingPhoto.context).load(dataForm?.photo.toString()).into(ingPhoto)
        textView.text = formatoSalida


        val btnBack: Button = findViewById(R.id.buttonBack)

        btnBack.setOnClickListener {

            val intentBack = Intent(this, MainActivity::class.java)
            startActivity(intentBack)
        }

    }
}
