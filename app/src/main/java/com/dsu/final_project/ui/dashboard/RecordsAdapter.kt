package com.dsu.final_project.ui.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dsu.final_project.databinding.ItemLikedFavRecBinding
import com.dsu.final_project.model.datamodel.Record

class RecordsAdapter(private val context: Context, private val records: List<Record>) : RecyclerView.Adapter<RecordsAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLikedFavRecBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = records[position]
        holder.binding.tvFavName.text = model.name
        holder.binding.tvFavDesc.text = model.description
    }

    override fun getItemCount(): Int {
        return records.size
    }

    class ViewHolder(val binding: ItemLikedFavRecBinding): RecyclerView.ViewHolder(binding.root)
}