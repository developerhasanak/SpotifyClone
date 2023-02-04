package com.example.android.uamp.media;

import java.lang.System;

/**
 * A [MediaItemConverter] to convert from a [MediaItem] to a Cast [MediaQueueItem].
 *
 * It adds all audio specific metadata properties and creates a Cast metadata object of type
 * [MediaMetadata.MEDIA_TYPE_MUSIC_TRACK].
 *
 * To create an artwork for Cast we can't use the standard [MediaItem#mediaMetadata#artworkUri]
 * because UAMP uses a content provider to serve cached bitmaps. The URIs starting with `content://`
 * are useless on a Cast device, so we need to use the original HTTP URI that the [JsonSource]
 * stores in the metadata extra with key `JsonSource.ORIGINAL_ARTWORK_URI_KEY`.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/android/uamp/media/CastMediaItemConverter;", "Lcom/google/android/exoplayer2/ext/cast/MediaItemConverter;", "()V", "defaultMediaItemConverter", "Lcom/google/android/exoplayer2/ext/cast/DefaultMediaItemConverter;", "toMediaItem", "Lcom/google/android/exoplayer2/MediaItem;", "mediaQueueItem", "Lcom/google/android/gms/cast/MediaQueueItem;", "toMediaQueueItem", "mediaItem", "common_debug"})
public final class CastMediaItemConverter implements com.google.android.exoplayer2.ext.cast.MediaItemConverter {
    private final com.google.android.exoplayer2.ext.cast.DefaultMediaItemConverter defaultMediaItemConverter = null;
    
    public CastMediaItemConverter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.google.android.gms.cast.MediaQueueItem toMediaQueueItem(@org.jetbrains.annotations.NotNull()
    com.google.android.exoplayer2.MediaItem mediaItem) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.google.android.exoplayer2.MediaItem toMediaItem(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.cast.MediaQueueItem mediaQueueItem) {
        return null;
    }
}