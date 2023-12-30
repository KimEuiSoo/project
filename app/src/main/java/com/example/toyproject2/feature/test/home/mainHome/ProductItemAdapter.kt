package com.example.toyproject2.feature.test.home.mainHome

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.toyproject2.R
import com.example.toyproject2.data.local.ProductItem
import java.text.DecimalFormat

class ProductItemAdapter(private var context: Context, private var items: ArrayList<ProductItem>, val onClick: (ProductItem) -> Unit) :
    RecyclerView.Adapter<ProductItemAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val resourceId = context.resources.getIdentifier(
            items[position].image,
            "drawable",
            context.packageName
        )
        holder.price.text = formatAccount(items[position].account)
        holder.title.text = items[position].title
        holder.deabline.text = items[position].deadline
        holder.image.setImageResource(resourceId)
        holder.itemView.setOnClickListener {
            onClick(items[position])
        }
    }

    fun formatAccount(account: Int): String {
        var formatPrice: String = ""
        val dec = DecimalFormat("#,###")
        formatPrice = dec.format(account)+" 원"
        return formatPrice
    }

    //list_view_item.xml의 TextView를 연동시켜줌
    inner class ProductViewHolder(itemView: View) : ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.product_image)
        val title = itemView.findViewById<TextView>(R.id.product_title)
        val price = itemView.findViewById<TextView>(R.id.product_price)
        val deabline = itemView.findViewById<TextView>(R.id.product_deadline)
    }
}