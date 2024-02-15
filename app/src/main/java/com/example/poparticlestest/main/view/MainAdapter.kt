package com.example.poparticlestest.main.view

import IOnItemClickViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.poparticlestest.R
import com.example.poparticlestest.main.datasource.entity.ViewedArticle

class MainAdapter(
    var isDelete: Boolean = false,
    var dataList: List<ViewedArticle> = mutableListOf(),
    private val onItemClickListener: IOnItemClickViewHolder
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view_cell, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val data = dataList[position]
        holder.textName.text = data.title
        holder.textDescription.text = data.abstract



        holder.ivIcon.setOnClickListener {
            onItemClickListener.onItemClick(it, position, data.id)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    fun setData(characters: List<ViewedArticle>) {
        dataList = characters
        notifyDataSetChanged()
    }

    class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivIcon = view.findViewById<ImageView>(R.id.main_photo_image)
        val textName = view.findViewById<TextView>(R.id.character_type_text)
        val textDescription = view.findViewById<TextView>(R.id.description_value_text)
    }

}