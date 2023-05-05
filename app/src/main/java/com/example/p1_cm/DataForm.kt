package com.example.p1_cm

import android.os.Parcel
import  android.os.Parcelable


data class DataForm(
    val nombreCompleto: String?,
    val edad: String?,
    val signoZodiacal: String?,
    val signoChino: String?,
    val elemento: String?,
    val email: String?,
    val numCuenta: String?,
    val carrera: String?,
    val photo: String?
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombreCompleto)
        parcel.writeString(edad)
        parcel.writeString(signoZodiacal)
        parcel.writeString(signoChino)
        parcel.writeString(elemento)
        parcel.writeString(email)
        parcel.writeString(numCuenta)
        parcel.writeString(carrera)
        parcel.writeString(photo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataForm> {
        override fun createFromParcel(parcel: Parcel): DataForm {
            return DataForm(parcel)
        }

        override fun newArray(size: Int): Array<DataForm?> {
            return arrayOfNulls(size)
        }
    }
}
