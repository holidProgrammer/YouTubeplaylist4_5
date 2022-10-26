package com.example.youtubeplaylists.ui.ui.fragments.playlists

import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.youtubeplaylists.R
import com.example.youtubeplaylists.databinding.FragmentPlaylistsBinding
import com.example.youtubeplaylists.ui.ext.hide
import com.example.youtubeplaylists.ui.ext.show
import com.example.youtubeplaylists.ui.core.Resource
import com.example.ytparser.model.Item
import com.example.youtubeplaylists.ui.ui.base.BaseFragment
import com.google.gson.Gson
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlaylistFragment: BaseFragment<FragmentPlaylistsBinding>(R.layout.fragment_playlists), PlaylistAdapter.ItemClick {

    private lateinit var playlistAdapter: PlaylistAdapter

    override val binding by viewBinding(FragmentPlaylistsBinding::bind)
    private val viewModel: PlaylistsViewModel by viewModel()

    override fun initialize() {
        playlistAdapter = PlaylistAdapter(this)
        binding.rvVideo.adapter = playlistAdapter
    }

    override fun setupClickListeners() {
    }

    override fun setupObservers() {
        viewModel.fetchPlaylists().observe(viewLifecycleOwner) { response ->
            when(response) {
                is Resource.Loading -> {
                    binding.progress.show()
                }
                is Resource.Error -> {
                    binding.progress.hide()
                }
                is Resource.Success -> {
                    binding.progress.hide()
                    Log.d("PlaylistFragment", Gson().toJson(response.data?.items.toString()))
                    response.data?.let { playlistAdapter.setPlaylist(it.items) }
                }
            }
        }
    }

    override fun clickListener(item: Item) {
        val bundle = Bundle()
        bundle.putSerializable("item", item)
        findNavController().navigate(R.id.action_playlistFragment_to_detailFragment, bundle)
    }

}