package com.dsu.final_project.ui.favourites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dsu.final_project.databinding.ItemLikedFavRecBinding
import com.dsu.final_project.datamodel.Record

class FavouriteAdapter(private val fav_record:List<Record>):RecyclerView.Adapter<FavouriteAdapter.FavViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavViewHolder {
        return FavViewHolder(ItemLikedFavRecBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: FavViewHolder, position: Int) {
        val fav_record=fav_record.get(position)
        holder.binding.tvFavName.text=fav_record.name
        if(!fav_record.isFav)
            holder.binding.ivIconFav.visibility= View.GONE
    }

    override fun getItemCount(): Int {
        return fav_record.size
    }
    class FavViewHolder(val binding: ItemLikedFavRecBinding):RecyclerView.ViewHolder(binding.root)
}