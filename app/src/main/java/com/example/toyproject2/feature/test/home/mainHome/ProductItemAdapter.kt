package com.example.toyproject2.feature.test.home.mainHome

import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.marginLeft
import androidx.core.view.setMargins
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.toyproject2.R
import com.example.toyproject2.data.local.ProductItem
import java.text.DecimalFormat

class ProductItemAdapter(private var context: Context, private var items: ArrayList<ProductItem>, private var type: ProductType, val onClick: (ProductItem, String) -> Unit) :
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
            onClick(items[position], "")
        }

        holder.favorite.setOnClickListener{
            changeBackground(holder)
            onClick(items[position], "favorite")
        }

        when(type){
            ProductType.BEST -> productBest(holder)
            ProductType.NEW -> productNew(holder)
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
        val title: TextView = itemView.findViewById<TextView>(R.id.product_title)
        val price: TextView = itemView.findViewById<TextView>(R.id.product_price)
        val deabline: TextView = itemView.findViewById<TextView>(R.id.product_deadline)
        val favorite: ImageView = itemView.findViewById<ImageView>(R.id.product_favorite)
    }

    fun productBest(holder: ProductViewHolder){
        holder.title.setTextColor(ContextCompat.getColor(context, R.color.white))
    }

    fun productNew(holder: ProductViewHolder){
        val pixelValue = dpToPx(context, 158f)

        holder.title.setTextColor(ContextCompat.getColor(context, R.color.black))
        holder.title.layoutParams.width = pixelValue
        holder.image.layoutParams.width = pixelValue
        holder.image.layoutParams.height = pixelValue
        holder.price.layoutParams.width = pixelValue
        holder.deabline.layoutParams.width = pixelValue
    }

    fun dpToPx(context: Context, dp: Float): Int {
        val density = context.resources.displayMetrics.density
        return (dp * density + 0.5f).toInt()
    }

    fun changeBackground(holder: ProductViewHolder){
        holder.favorite.setBackgroundResource(R.drawable.ic_favorite_24)
        val colorStateList = ColorStateList.valueOf(holder.favorite.context.resources.getColor(R.color.favorite_red))
        holder.favorite.backgroundTintList = colorStateList
    }
}