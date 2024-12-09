package com.example.jetpack_compose.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack_compose.databinding.ItemElipsodeBinding
import com.example.jetpack_compose.entity.Episode

class EpisodeAdapter : RecyclerView.Adapter<MyViewHolder>() {
    var episodesCount = 1
    private var data: List<Episode> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemElipsodeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun setData(data: List<Episode>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = episodesCount

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = data.getOrNull(position)
        with(holder.binding) {
            name.text = item?.name
            episode.text = item?.episode
            date.text = item?.air_date
        }
    }
}

class MyViewHolder(val binding: ItemElipsodeBinding) : RecyclerView.ViewHolder(binding.root)

