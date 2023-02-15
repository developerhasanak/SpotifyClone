package com.ak.spotifyclone.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.ak.spotifyclone.R
import com.ak.spotifyclone.adapters.SongAdapter
import com.ak.spotifyclone.adapters.SwipeSongAdapter
import com.ak.spotifyclone.databinding.FragmentHomeBinding
import com.ak.spotifyclone.ui.viewmodel.MainViewModel
import com.ak.spotifyclone.util.Status
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    lateinit var viewModel: MainViewModel

    @Inject
    lateinit var songadapter: SongAdapter

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        setupRecyclerView()
        subscribeToObservers()

        songadapter.setOnItemClickListener {
            viewModel.playOrToggleSong(it)
        }

    }

    private fun setupRecyclerView() = binding.rvAllSongs.apply {
        adapter = songadapter
        layoutManager = LinearLayoutManager(requireContext())
    }


    private fun subscribeToObservers() {
        viewModel.mediaItems.observe(viewLifecycleOwner) { result ->
            when (result.status) {
                Status.SUCCESS -> {
                    binding.allSongsProgressBar.isVisible = false
                    result.data?.let {
                        songadapter.songs = it

                    }
                }
                Status.ERROR -> Unit
                Status.LOADING -> binding.allSongsProgressBar.isVisible = true
            }
        }
    }

}