package com.example.toyproject2.feature.test.home.mainHome

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.toyproject2.R
import com.example.toyproject2.data.local.DataPage
import android.content.Context

class ImageSliderAdapter(private val context: Context, private val images: ArrayList<DataPage>) :
    RecyclerView.Adapter<ImageSliderAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.banner_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val resourceId = context.resources.getIdentifier(
            images[position].image,
            "drawable",
            context.packageName
        )
        holder.image.setImageResource(resourceId)
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById<ImageView>(R.id.imageSlider)
    }
}