package com.dsu.final_project.ui.favourites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dsu.final_project.databinding.ItemLikedFavRecBinding
import com.dsu.final_project.databinding.ItemUnlikeFavRecBinding
import com.dsu.final_project.model.datamodel.FavouriteRecord

class FavouriteAdapter(private val fav_records: List<FavouriteRecord>) : RecyclerView.Adapter<FavouriteAdapter.LikeViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LikeViewHolder {
        return LikeViewHolder(
            ItemLikedFavRecBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: LikeViewHolder, position: Int) {
        val fav_records = fav_records.get(position)
        holder.binding.tvFavName.text = fav_records.FirstName
        holder.binding.tvFavDesc.text =fav_records.lastName;
    }

    override fun getItemCount(): Int {
        return fav_records.size
    }

    class LikeViewHolder(val binding: ItemLikedFavRecBinding): RecyclerView.ViewHolder(binding.root)
    class UnlikeViewHolder(val binding: ItemUnlikeFavRecBinding): RecyclerView.ViewHolder(binding.root)
}