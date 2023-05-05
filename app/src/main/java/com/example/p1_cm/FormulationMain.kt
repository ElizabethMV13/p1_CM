package com.example.p1_cm

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.Period
import java.util.Calendar

class FormulationMain : AppCompatActivity() {

    val c: Calendar = Calendar.getInstance()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulation_main)

        val btnBack: Button = findViewById(R.id.buttonBack)

        btnBack.setOnClickListener{
            val builder = AlertDialog.Builder(this)

            builder.setTitle(R.string.titleAlert)
            builder.setMessage(getString(R.string.messageAlert))
            builder.setPositiveButton(getString(R.string.back)){_,_ ->
                finish()
            }

            builder.setNegativeButton(getString(R.string.submit)){dialog,_ ->
                dialog.dismiss()
            }
            val  dialog = builder.create()
            dialog.show()

        }

        val btnGo: Button = findViewById(R.id.buttonGo)

        btnGo.setOnClickListener{

            val nameEditText = findViewById<EditText>(R.id.name).text.toString()
            val lastNameEditText = findViewById<EditText>(R.id.last_name).text.toString()
            val emailEditText = findViewById<EditText>(R.id.editTextTextEmailAddress).text.toString()
            val numberEditText = findViewById<EditText>(R.id.editTextNumber).text.toString()
            val posicion = findViewById<Spinner>(R.id.spinner_ing).selectedItemPosition
            val nameCarrera = findViewById<Spinner>(R.id.spinner_ing).selectedItem.toString()

            val day: Int = c.get(Calendar.DAY_OF_MONTH)
            val month: Int = c.get(Calendar.MONTH)
            val year:Int = c.get(Calendar.YEAR)
            val emailPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$".toRegex()
            var listaErrores: String = """"""

            if (nameEditText.isEmpty()) {
                listaErrores = listaErrores + "\n " + getString(R.string.concat1) + getString(R.string.name_form)
            }
            if (!noContieneNumeros(nameEditText) && !nameEditText.isEmpty()) {
                listaErrores = listaErrores+"\n " + getString(R.string.concat2) + getString(R.string.name_form)
            }
            if(lastNameEditText.isEmpty()){
                listaErrores = listaErrores + "\n" + getString(R.string.concat1) + getString(R.string.last_name_form)
            }
            if (!noContieneNumeros(lastNameEditText) && !lastNameEditText.isEmpty()) {
               listaErrores = listaErrores + "\n" + getString(R.string.concat2) + getString(R.string.last_name_form)
            }

            if(numberEditText.isEmpty()){
                listaErrores = listaErrores + "\n" + getString(R.string.concat1) + getString(R.string.num_cuenta_from)
            }
            if (numberEditText.length !=9 && !numberEditText.isEmpty()){
                listaErrores = listaErrores + "\n" + getString(R.string.concat3)
            }

            if (emailEditText.isEmpty()){
                listaErrores = listaErrores + "\n" + getString(R.string.concat1) + getString(R.string.correo_form)
            }
            if (!emailEditText.matches(emailPattern) && !emailEditText.isEmpty()) {
                listaErrores =
                    listaErrores + "\n" + getString(R.string.concat2) + getString(R.string.correo_form)
            }

            if (posicion == 0) {
                listaErrores = listaErrores + "\n" + getString(R.string.concat5)
            }



            if (listaErrores === "") {

                val nombreCompleto = nameEditText.toString().plus(" ").plus(lastNameEditText.toString())
                val signoZodiacal = obtenerSignoZodiacal( "$month", "$day")
                val (signoChino, elemento)= obtenerSignoChino("$year")
                val edad = calcularEdad("$year","$month", "$day")


                val  intentSend: Intent = Intent(this,Resumen::class.java)
                intentSend.putExtra(
                    "DataForm",
                    DataForm("$nombreCompleto","$edad","$signoZodiacal","$signoChino","$elemento","$emailEditText","$numberEditText","$nameCarrera ","https://www.ingenieria.unam.mx/programas_academicos/images/carreras/computacion.jpg"))
                startActivity(intentSend)

            } else {

                var message = getString(R.string.messageError) + "\n" + listaErrores

                val builder = AlertDialog.Builder(this)
                builder.setTitle(R.string.error)
                builder.setMessage(message)
                builder.setPositiveButton(R.string.ok, null)
                val dialog = builder.create()
                dialog.show()
            }
        }

        val spinner = findViewById<Spinner>(R.id.spinner_ing)
        val list = ingspinnerProvider.listSpinner

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, list)
        spinner.adapter = adapter
        //De aqui se puede optener el valor del dropdown
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                spinner.selectedItem.toString()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }

    fun onClickScheduledDate(v: View?) {
        val etScheduledDate = findViewById<EditText>(R.id.datePicker)

        val day: Int = c.get(Calendar.DAY_OF_MONTH)
        val month: Int = c.get(Calendar.MONTH)
        val year: Int = 1950

        val listener = DatePickerDialog.OnDateSetListener { datePicker, y, m, d ->

            c.set(y, m, d)
            etScheduledDate.setText("$y-$m-$d")

        }

        val datePickerDialog = DatePickerDialog(this, listener, year, month, day)
        datePickerDialog.datePicker.minDate = getMillisFromYearMonthDay(1900, 1, 1)
        datePickerDialog.datePicker.maxDate = getMillisFromYearMonthDay(2023, 4, 4)
        datePickerDialog.show()
    }

    fun obtenerSignoChino(anio: String): Pair<String, String> {

        val anio = anio.toInt()

            val zodiacSigns = arrayOf("Rata", "Buey", "Tigre", "Conejo", "Dragón", "Serpiente", "Caballo", "Cabra", "Mono", "Gallo", "Perro", "Cerdo")
            val elements = arrayOf("Madera", "Fuego", "Tierra", "Metal", "Agua")
            val startYear = 1900
            val offset = anio - startYear
            val zodiacIndex = offset % 12
            val elementIndex = (offset / 2) % 5
            return Pair(zodiacSigns[zodiacIndex], elements[elementIndex])
        }


    fun obtenerSignoZodiacal(mes: String, dia: String): String {

        var mes = mes.toInt()
        val dia = dia.toInt()

        if (mes >=8 ){ mes = mes + 1}

        return when {
            mes == 1 && dia >= 20 || mes == 2 && dia < 19 -> "Acuario"
            mes == 2 && dia >= 19 || mes == 3 && dia < 21 -> "Piscis"
            mes == 3 && dia >= 21 || mes == 4 && dia < 20 -> "Aries"
            mes == 4 && dia >= 20 || mes == 5 && dia < 21 -> "Tauro"
            mes == 5 && dia >= 21 || mes == 6 && dia < 21 -> "Géminis"
            mes == 6 && dia >= 21 || mes == 7 && dia < 23 -> "Cáncer"
            mes == 7 && dia >= 23 || mes == 8 && dia < 23 -> "Leo"
            mes == 8 && dia >= 23 || mes == 9 && dia < 23 -> "Virgo"
            mes == 9 && dia >= 23 || mes == 10 && dia < 23 -> "Libra"
            mes == 10 && dia >= 23 || mes == 11 && dia < 22 -> "Escorpio"
            mes == 11 && dia >= 22 || mes == 12 && dia < 22 -> "Sagitario"
            mes == 12 && dia >= 22 || mes == 1 && dia < 20 -> "Capricornio"
            else -> "Error: fecha inválida"
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun calcularEdad(anio: String, mes: String, dia: String): String {
        var anio = anio.toInt()
        var mes = mes.toInt()
        val dia = dia.toInt()

        val fechaActual = LocalDate.now()
        val fechaNacimiento = LocalDate.of(anio, mes, dia)
        val edad = Period.between(fechaNacimiento, fechaActual).years
        return edad.toString()
    }



    fun noContieneNumeros(cadena: String): Boolean {
        //val patron = Regex("\\D+")
        //return patron.matches(cadena)
        val patron = Regex("[a-zA-Z]+")
        return patron.matches(cadena)
    }


    private fun getMillisFromYearMonthDay(year: Int, month: Int, day: Int): Long {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, day)
        return calendar.timeInMillis
    }
}
