package com.ak.spotifyclone.exoplayer.callbacks

import android.widget.Toast
import com.ak.spotifyclone.exoplayer.MusicService
import com.google.android.exoplayer2.PlaybackException
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector.PlaybackPreparer

class MusicPlayerEventListener(
    private val  musicService: MusicService
) : Player.Listener {
    @Deprecated("Deprecated in Java")
    override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
        super.onPlayerStateChanged(playWhenReady, playbackState)
        if (playbackState == Player.STATE_READY && !playWhenReady){
            musicService.stopForeground(false)
        }
    }

    override fun onPlayerError(error: PlaybackException) {
        super.onPlayerError(error)
        Toast.makeText(musicService, "Bilinmeyen bir hata oluştu", Toast.LENGTH_LONG).show()
    }
}