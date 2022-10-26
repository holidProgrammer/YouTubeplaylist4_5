package com.example.youtubeplaylists.ui.ui.fragments.playlist_detail

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.youtubeplaylists.databinding.DetailedPlaceholderBinding
import com.example.youtubeplaylists.ui.ext.load
import com.example.ytparser.model.Item

class DetailAdapter : RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {

    private val dPlaylist = mutableListOf<Item>()
    @SuppressLint("NotifyDataSetChanged")
    fun setList(newData: List<Item>) {
        dPlaylist.clear()
        dPlaylist.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val binding: DetailedPlaceholderBinding =
            DetailedPlaceholderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.onBind(dPlaylist[position])

    }

    override fun getItemCount(): Int {
        return dPlaylist.size
    }

    class DetailViewHolder(private val binding: DetailedPlaceholderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Item) {
            binding.imgPreView.load(item.snippet.thumbnails.default.url)
            binding.tvDescription.text = item.snippet.description
            binding.dayTime.text = item.snippet.publishedAt.toString()
        }
    }
}