package com.example.youtubeplaylists.ui.ui.fragments.playlists

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.youtubeplaylists.databinding.VideoPlaceholderBinding
import com.example.ytparser.model.Item

class PlaylistAdapter(private val itemClick: ItemClick) : RecyclerView.Adapter<PlaylistAdapter.ItemViewHolder>() {

    private var mplaylist = mutableListOf<Item>()
    @SuppressLint("NotifyDataSetChanged")
    fun setPlaylist(newData: List<Item>) {
        mplaylist.clear()
        mplaylist.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding: VideoPlaceholderBinding =
            VideoPlaceholderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(mplaylist[position])
        holder.itemView.setOnClickListener {
            itemClick.clickListener(mplaylist[position])
        }
    }

    override fun getItemCount(): Int {
        return mplaylist.size
    }

    class ItemViewHolder(private val binding: VideoPlaceholderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(item: Item){
            binding.textTitle.text = item.snippet.title
            binding.textVideoSeries.text = item.contentDetails.itemCount.toString() + " video series"
            binding.playlistText.text = item.snippet.channelTitle
            binding.preView.load(item.snippet.thumbnails.medium.url)
        }
    }

    interface ItemClick {
        fun clickListener(item: Item)
    }
}