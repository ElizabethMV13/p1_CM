package com.example.p1_cm

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.p1_cm.Engineering
import com.example.p1_cm.R

class EngineeringViewHolder(view:View):RecyclerView.ViewHolder(view) {
    val ing = view.findViewById<TextView>(R.id.item_name)
    val ingIntro = view.findViewById<TextView>(R.id.item_info)
    val ingOption = view.findViewById<TextView>(R.id.item_mas)
    val ingPhoto = view.findViewById<ImageView>(R.id.item_img)

    fun render(EngineeringModel: Engineering){
        ing.text = EngineeringModel.nameIng
        ingIntro.text = EngineeringModel.info
        ingOption.text = EngineeringModel.mas
        Glide.with(ingPhoto.context).load(EngineeringModel.photo).into(ingPhoto)

    }
}