package com.example.task_027

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val clothes: MutableList<ClothesViewModal>):
    RecyclerView.Adapter<CustomAdapter.ClothesViewHolder>(){

    private var onClothesViewModalClickListener: OnClothesViewModalClickListener? = null

    interface OnClothesViewModalClickListener {
        fun onClothesViewModalClick(clothesType: ClothesViewModal, position: Int)
    }

    class ClothesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageViewIV: ImageView = itemView.findViewById(R.id.imageViewIV)
        val nameTV: TextView = itemView.findViewById(R.id.nameTV)
        val descriptionTV: TextView = itemView.findViewById(R.id.descriptionTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClothesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ClothesViewHolder(itemView)
    }

    override fun getItemCount() = clothes.size

    override fun onBindViewHolder(holder: ClothesViewHolder, position: Int) {
        val clothesType = clothes[position]
        holder.imageViewIV.setImageResource(clothesType.image)
        holder.nameTV.text = clothesType.name
        holder.descriptionTV.text = clothesType.description
        holder.itemView.setOnClickListener{
            if (onClothesViewModalClickListener != null) {
                onClothesViewModalClickListener!!.onClothesViewModalClick(clothesType, position)
            }
        }
    }

    fun setOnClothesViewModalClickListener(onClothesViewModalClickListener: OnClothesViewModalClickListener) {
        this.onClothesViewModalClickListener = onClothesViewModalClickListener
    }
}