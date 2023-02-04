package com.ak.spotifyclone.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ak.spotifyclone.data.entities.Song
import com.ak.spotifyclone.databinding.ListItemBinding
import com.bumptech.glide.RequestManager
import javax.inject.Inject

class SongAdapter @Inject constructor(
    private val glide : RequestManager
):RecyclerView.Adapter<SongAdapter.SongViewHOlder>(){
    class SongViewHOlder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {

    }

    private val diffCallback = object : DiffUtil.ItemCallback<Song>(){
        override fun areItemsTheSame(oldItem: Song, newItem: Song): Boolean {
            return oldItem.mediaId == newItem.mediaId
        }

        override fun areContentsTheSame(oldItem: Song, newItem: Song): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

    }

    private val differ = AsyncListDiffer(this,diffCallback)

    var songs: List<Song>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHOlder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SongViewHOlder(binding)
    }

    override fun getItemCount(): Int {
        return songs.size
    }

    override fun onBindViewHolder(holder: SongViewHOlder, position: Int) {
       holder.binding.song = songs[position]
       holder.itemView.setOnClickListener {
           onItemClickListener?.let {click ->
               click(songs[position])

           }
       }

    }

    private var onItemClickListener: ((Song) -> Unit)? = null

    fun setOnItemClickListener(listener: (Song) -> Unit) {
        onItemClickListener = listener
    }
}