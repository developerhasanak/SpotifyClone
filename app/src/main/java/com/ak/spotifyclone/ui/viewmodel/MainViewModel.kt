package com.ak.spotifyclone.ui.viewmodel


import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.MediaMetadataCompat.METADATA_KEY_MEDIA_ID
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ak.spotifyclone.data.entities.Song
import com.ak.spotifyclone.exoplayer.MusicServiceConnection
import com.ak.spotifyclone.exoplayer.isPlayEnablea
import com.ak.spotifyclone.exoplayer.isPlaying
import com.ak.spotifyclone.exoplayer.isPrepared
import com.ak.spotifyclone.util.Constants.MEDIA_ROOT_ID
import com.ak.spotifyclone.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val musicServiceConnection: MusicServiceConnection
) : ViewModel() {




    private val _mediaItems = MutableLiveData<Resource<List<Song>>>()
    val mediaItems : LiveData<Resource<List<Song>>> = _mediaItems

    val isConnected = musicServiceConnection.isConnected
    val networkError = musicServiceConnection.networkError
    val currentPlayingSong = musicServiceConnection.curPlayingSong
    val playbackState = musicServiceConnection.playbackState

    init {
         _mediaItems.postValue(Resource.loading(null))
         musicServiceConnection.subscribe(MEDIA_ROOT_ID, object : MediaBrowserCompat.SubscriptionCallback(){
             override fun onChildrenLoaded(
                 parentId: String,
                 children: MutableList<MediaBrowserCompat.MediaItem>
             ) {
                 super.onChildrenLoaded(parentId, children)
                 val items = children.map {
                     Song(
                         it.mediaId!!,
                         it.description.title.toString(),
                         it.description.subtitle.toString(),
                         it.description.mediaUri.toString(),
                         it.description.iconUri.toString()
                     )
                 }
                 _mediaItems.postValue(Resource.success(items))

             }
         })

    }

    fun skipToNextSong(){
        musicServiceConnection.transportControls.skipToNext()
    }

    fun skipToPreviosSong(){
        musicServiceConnection.transportControls.skipToPrevious()
    }

    fun seekTo(position:Long){
        musicServiceConnection.transportControls.seekTo(position)
    }

    fun playOrToggleSong(mediaItem: Song, toggle: Boolean = false){
        val isPrepared = playbackState.value?.isPrepared ?: false
        if (isPrepared && mediaItem.mediaId ==
            currentPlayingSong.value?.getString(METADATA_KEY_MEDIA_ID)) {
            playbackState.value?.let { playbackState->
                when{
                    playbackState.isPlaying -> if(toggle) musicServiceConnection.transportControls.pause()
                    playbackState.isPlayEnablea -> musicServiceConnection.transportControls.play()
                    else -> Unit
                }
            }

        } else {
            musicServiceConnection.transportControls.playFromMediaId(mediaItem.mediaId,null)
        }
    }

    override fun onCleared() {
        super.onCleared()
        musicServiceConnection.unsubscribe(MEDIA_ROOT_ID,object : MediaBrowserCompat.SubscriptionCallback() {})
    }
}