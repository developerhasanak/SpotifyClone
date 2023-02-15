package com.ak.spotifyclone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.media.session.PlaybackStateCompat
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.ak.spotifyclone.R
import com.ak.spotifyclone.adapters.SwipeSongAdapter
import com.ak.spotifyclone.data.entities.Song
import com.ak.spotifyclone.databinding.ActivityMainBinding
import com.ak.spotifyclone.exoplayer.isPlaying
import com.ak.spotifyclone.exoplayer.toSong
import com.ak.spotifyclone.ui.viewmodel.MainViewModel
import com.ak.spotifyclone.util.Status
import com.ak.spotifyclone.util.Status.ERROR
import com.bumptech.glide.RequestManager
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity @Inject constructor() : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    @Inject
    lateinit var swipeSongAdapter: SwipeSongAdapter

    @Inject
    lateinit var glide: RequestManager

    private var currentPlayingSong: Song? = null

    private var playbackState: PlaybackStateCompat? = null

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        subscribeToObservers()



        binding.vpSong.adapter = swipeSongAdapter

        binding.vpSong.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (playbackState?.isPlaying == true) {
                    viewModel.playOrToggleSong(swipeSongAdapter.songs[position])
                } else {
                    currentPlayingSong = swipeSongAdapter.songs[position]
                }
            }
        })

        binding.ivPlayPause.setOnClickListener {
            currentPlayingSong?.let {
                viewModel.playOrToggleSong(it, true)
            }
        }


        swipeSongAdapter.setItemClickListener {
            navHostFragment.findNavController().navigate(R.id.globalActionToSongFragment)
        }


        navHostFragment.findNavController().addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.songFragment -> hideBottomBar()
                R.id.homeFragment -> showBottomBar()
                else -> showBottomBar()
            }
        }

    }

    private fun hideBottomBar() {
        binding.vpSong.isVisible = false
        binding.ivCurSongImage.isVisible = false
        binding.ivPlayPause.isVisible = false
    }

    private fun showBottomBar() {
        binding.vpSong.isVisible = true
        binding.ivCurSongImage.isVisible = true
        binding.ivPlayPause.isVisible = true
    }

    private fun switchViewPagerToCurentSong(song: Song) {
        val newIndex = swipeSongAdapter.songs.indexOf(song)
        if (newIndex != -1) {
            binding.vpSong.currentItem = newIndex
            currentPlayingSong = song
        }
    }

    private fun subscribeToObservers() {
        viewModel.mediaItems.observe(this) {
            it?.let { result ->
                when (result.status) {
                    Status.SUCCESS -> {
                        result.data?.let { songs ->
                            swipeSongAdapter.songs = songs
                            if (songs.isNotEmpty()) {
                                glide.load((currentPlayingSong ?: songs[0].imageUrl))
                                    .into(binding.ivCurSongImage)
                            }
                            switchViewPagerToCurentSong(currentPlayingSong ?: return@observe)
                        }
                    }
                    Status.LOADING -> Unit
                    ERROR -> Unit
                }
            }
        }
        viewModel.currentPlayingSong.observe(this) {
            if (it == null) return@observe

            currentPlayingSong = it.toSong()
            glide.load(currentPlayingSong?.imageUrl).into(binding.ivCurSongImage)
            switchViewPagerToCurentSong(currentPlayingSong ?: return@observe)
        }
        viewModel.playbackState.observe(this) {
            playbackState = it
            binding.ivPlayPause.setImageResource(
                if (playbackState?.isPlaying == true) R.drawable.ic_pause else R.drawable.ic_play
            )
        }
        viewModel.isConnected.observe(this) {
            it?.getContentIfNotHandled()?.let { result ->
                when (result.status) {
                    ERROR -> Snackbar.make(
                        binding.rootLayout,
                        result.message ?: "Bilinmeyen bir hata oluştu",
                        Snackbar.LENGTH_LONG
                    ).show()
                    else -> Unit
                }
            }
        }
        viewModel.networkError.observe(this) {
            it?.getContentIfNotHandled()?.let { result ->
                when (result.status) {
                    ERROR -> Snackbar.make(
                        binding.rootLayout,
                        result.message ?: "Bilinmeyen bir hata oluştu",
                        Snackbar.LENGTH_LONG
                    ).show()
                    else -> Unit
                }
            }
        }

    }
}