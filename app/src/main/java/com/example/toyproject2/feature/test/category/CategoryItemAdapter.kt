package com.example.toyproject2.feature.test.category

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.toyproject2.R
import com.example.toyproject2.data.local.CategoryItem

class CategoryItemAdapter(private var context: Context, private var items: ArrayList<CategoryItem>, private var type: CategoryType, val onClick: (CategoryItem) -> Unit)
    : RecyclerView.Adapter<CategoryItemAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item_list, parent, false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val resourceId = context.resources.getIdentifier(
            items[position].categoryImage,
            "drawable",
            context.packageName
        )

        holder.image.setImageResource(resourceId)
        holder.title.text = items[position].title
        holder.itemView.setOnClickListener {
            onClick(items[position])
        }
    }

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val itemCategory: ConstraintLayout = itemView.findViewById(R.id.category_item)
        val image: ImageView = itemView.findViewById(R.id.category_image)
        val title: TextView = itemView.findViewById(R.id.category_title)
    }
}