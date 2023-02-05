package com.ak.spotifyclone.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ak.spotifyclone.data.entities.Song
import com.ak.spotifyclone.databinding.ListItemBinding
import com.ak.spotifyclone.databinding.SwipeItemBinding

class SwipeSongAdapter: RecyclerView.Adapter<SwipeSongAdapter.SwipeSongViewHolder>(){

    class SwipeSongViewHolder(val binding: SwipeItemBinding): RecyclerView.ViewHolder(binding.root) {

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SwipeSongViewHolder {
        val binding = SwipeItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SwipeSongViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return songs.size
    }

    override fun onBindViewHolder(holder: SwipeSongViewHolder, position: Int) {
        val song = songs[position]
        holder.binding.song = songs[position]
        holder.itemView.setOnClickListener {
            onItemClickListener?.let {click ->
                click(song)

            }
        }

    }

     var onItemClickListener: ((Song) -> Unit)? = null

    fun setItemClickListener(listener: (Song) -> Unit) {
        onItemClickListener = listener
    }
}