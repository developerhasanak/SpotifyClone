package com.example.android.uamp.media;

import java.lang.System;

/**
 * This class is the entry point for browsing and playback commands from the APP's UI
 * and other apps that wish to play music via UAMP (for example, Android Auto or
 * the Google Assistant).
 *
 * Browsing begins with the method [MusicService.onGetRoot], and continues in
 * the callback [MusicService.onLoadChildren].
 *
 * For more information on implementing a MediaBrowserService,
 * visit [https://developer.android.com/guide/topics/media-apps/audio-app/building-a-mediabrowserservice.html](https://developer.android.com/guide/topics/media-apps/audio-app/building-a-mediabrowserservice.html).
 *
 * This class also handles playback for Cast sessions.
 * When a Cast session is active, playback commands are passed to a
 * [CastPlayer](https://exoplayer.dev/doc/reference/com/google/android/exoplayer2/ext/cast/CastPlayer.html),
 * otherwise they are passed to an ExoPlayer for local playback.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00c0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001:\u0005YZ[\\]B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010:\u001a\u00020;H\u0017J\b\u0010<\u001a\u00020;H\u0016J$\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u000f2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J$\u0010D\u001a\u00020;2\u0006\u0010E\u001a\u00020@2\u0012\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0\u00130GH\u0016J.\u0010I\u001a\u00020;2\u0006\u0010J\u001a\u00020@2\b\u0010K\u001a\u0004\u0018\u00010C2\u0012\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0\u00130GH\u0016J\u0010\u0010L\u001a\u00020;2\u0006\u0010M\u001a\u00020NH\u0016J0\u0010O\u001a\u00020;2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\u0010Q\u001a\u0004\u0018\u00010\u00142\u0006\u0010R\u001a\u00020\u001b2\u0006\u0010S\u001a\u00020TH\u0002J\b\u0010U\u001a\u00020;H\u0002J\u001a\u0010V\u001a\u00020;2\b\u0010W\u001a\u0004\u0018\u00010\u00112\u0006\u0010X\u001a\u00020\u0011H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\b\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX\u0084.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0084.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u000e\u0010(\u001a\u00020)X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082.\u00a2\u0006\u0002\n\u0000R\u0012\u0010.\u001a\u00060/R\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006^"}, d2 = {"Lcom/example/android/uamp/media/MusicService;", "Landroidx/media/MediaBrowserServiceCompat;", "()V", "browseTree", "Lcom/example/android/uamp/media/library/BrowseTree;", "getBrowseTree", "()Lcom/example/android/uamp/media/library/BrowseTree;", "browseTree$delegate", "Lkotlin/Lazy;", "castPlayer", "Lcom/google/android/exoplayer2/ext/cast/CastPlayer;", "getCastPlayer", "()Lcom/google/android/exoplayer2/ext/cast/CastPlayer;", "castPlayer$delegate", "currentMediaItemIndex", "", "currentPlayer", "Lcom/google/android/exoplayer2/Player;", "currentPlaylistItems", "", "Landroid/support/v4/media/MediaMetadataCompat;", "exoPlayer", "Lcom/google/android/exoplayer2/ExoPlayer;", "getExoPlayer", "()Lcom/google/android/exoplayer2/ExoPlayer;", "exoPlayer$delegate", "isForegroundService", "", "mediaSession", "Landroid/support/v4/media/session/MediaSessionCompat;", "getMediaSession", "()Landroid/support/v4/media/session/MediaSessionCompat;", "setMediaSession", "(Landroid/support/v4/media/session/MediaSessionCompat;)V", "mediaSessionConnector", "Lcom/google/android/exoplayer2/ext/mediasession/MediaSessionConnector;", "getMediaSessionConnector", "()Lcom/google/android/exoplayer2/ext/mediasession/MediaSessionConnector;", "setMediaSessionConnector", "(Lcom/google/android/exoplayer2/ext/mediasession/MediaSessionConnector;)V", "mediaSource", "Lcom/example/android/uamp/media/library/MusicSource;", "notificationManager", "Lcom/example/android/uamp/media/UampNotificationManager;", "packageValidator", "Lcom/example/android/uamp/media/PackageValidator;", "playerListener", "Lcom/example/android/uamp/media/MusicService$PlayerEventListener;", "remoteJsonSource", "Landroid/net/Uri;", "serviceJob", "Lkotlinx/coroutines/Job;", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "storage", "Lcom/example/android/uamp/media/PersistentStorage;", "uAmpAudioAttributes", "Lcom/google/android/exoplayer2/audio/AudioAttributes;", "onCreate", "", "onDestroy", "onGetRoot", "Landroidx/media/MediaBrowserServiceCompat$BrowserRoot;", "clientPackageName", "", "clientUid", "rootHints", "Landroid/os/Bundle;", "onLoadChildren", "parentMediaId", "result", "Landroidx/media/MediaBrowserServiceCompat$Result;", "Landroid/support/v4/media/MediaBrowserCompat$MediaItem;", "onSearch", "query", "extras", "onTaskRemoved", "rootIntent", "Landroid/content/Intent;", "preparePlaylist", "metadataList", "itemToPlay", "playWhenReady", "playbackStartPositionMs", "", "saveRecentSongToStorage", "switchToPlayer", "previousPlayer", "newPlayer", "PlayerEventListener", "PlayerNotificationListener", "UampCastSessionAvailabilityListener", "UampPlaybackPreparer", "UampQueueNavigator", "common_debug"})
public class MusicService extends androidx.media.MediaBrowserServiceCompat {
    private com.example.android.uamp.media.UampNotificationManager notificationManager;
    private com.example.android.uamp.media.library.MusicSource mediaSource;
    private com.example.android.uamp.media.PackageValidator packageValidator;
    private com.google.android.exoplayer2.Player currentPlayer;
    private final kotlinx.coroutines.Job serviceJob = null;
    private final kotlinx.coroutines.CoroutineScope serviceScope = null;
    protected android.support.v4.media.session.MediaSessionCompat mediaSession;
    protected com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector mediaSessionConnector;
    private java.util.List<android.support.v4.media.MediaMetadataCompat> currentPlaylistItems;
    private int currentMediaItemIndex = 0;
    private com.example.android.uamp.media.PersistentStorage storage;
    
    /**
     * This must be `by lazy` because the source won't initially be ready.
     * See [MusicService.onLoadChildren] to see where it's accessed (and first
     * constructed).
     */
    private final kotlin.Lazy browseTree$delegate = null;
    private boolean isForegroundService = false;
    private final android.net.Uri remoteJsonSource = null;
    private final com.google.android.exoplayer2.audio.AudioAttributes uAmpAudioAttributes = null;
    private final com.example.android.uamp.media.MusicService.PlayerEventListener playerListener = null;
    
    /**
     * Configure ExoPlayer to handle audio focus for us.
     * See [Player.AudioComponent.setAudioAttributes] for details.
     */
    private final kotlin.Lazy exoPlayer$delegate = null;
    
    /**
     * If Cast is available, create a CastPlayer to handle communication with a Cast session.
     */
    private final kotlin.Lazy castPlayer$delegate = null;
    
    public MusicService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final android.support.v4.media.session.MediaSessionCompat getMediaSession() {
        return null;
    }
    
    protected final void setMediaSession(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.session.MediaSessionCompat p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector getMediaSessionConnector() {
        return null;
    }
    
    protected final void setMediaSessionConnector(@org.jetbrains.annotations.NotNull()
    com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector p0) {
    }
    
    /**
     * This must be `by lazy` because the source won't initially be ready.
     * See [MusicService.onLoadChildren] to see where it's accessed (and first
     * constructed).
     */
    private final com.example.android.uamp.media.library.BrowseTree getBrowseTree() {
        return null;
    }
    
    /**
     * Configure ExoPlayer to handle audio focus for us.
     * See [Player.AudioComponent.setAudioAttributes] for details.
     */
    private final com.google.android.exoplayer2.ExoPlayer getExoPlayer() {
        return null;
    }
    
    /**
     * If Cast is available, create a CastPlayer to handle communication with a Cast session.
     */
    private final com.google.android.exoplayer2.ext.cast.CastPlayer getCastPlayer() {
        return null;
    }
    
    @kotlinx.coroutines.ExperimentalCoroutinesApi()
    @java.lang.Override()
    public void onCreate() {
    }
    
    /**
     * This is the code that causes UAMP to stop playing when swiping the activity away from
     * recents. The choice to do this is app specific. Some apps stop playback, while others allow
     * playback to continue and allow users to stop it with the notification.
     */
    @java.lang.Override()
    public void onTaskRemoved(@org.jetbrains.annotations.NotNull()
    android.content.Intent rootIntent) {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    /**
     * Returns the "root" media ID that the client should request to get the list of
     * [MediaItem]s to browse/play.
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public androidx.media.MediaBrowserServiceCompat.BrowserRoot onGetRoot(@org.jetbrains.annotations.NotNull()
    java.lang.String clientPackageName, int clientUid, @org.jetbrains.annotations.Nullable()
    android.os.Bundle rootHints) {
        return null;
    }
    
    /**
     * Returns (via the [result] parameter) a list of [MediaItem]s that are child
     * items of the provided [parentMediaId]. See [BrowseTree] for more details on
     * how this is build/more details about the relationships.
     */
    @java.lang.Override()
    public void onLoadChildren(@org.jetbrains.annotations.NotNull()
    java.lang.String parentMediaId, @org.jetbrains.annotations.NotNull()
    androidx.media.MediaBrowserServiceCompat.Result<java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem>> result) {
    }
    
    /**
     * Returns a list of [MediaItem]s that match the given search query
     */
    @java.lang.Override()
    public void onSearch(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.Nullable()
    android.os.Bundle extras, @org.jetbrains.annotations.NotNull()
    androidx.media.MediaBrowserServiceCompat.Result<java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem>> result) {
    }
    
    /**
     * Load the supplied list of songs and the song to play into the current player.
     */
    private final void preparePlaylist(java.util.List<android.support.v4.media.MediaMetadataCompat> metadataList, android.support.v4.media.MediaMetadataCompat itemToPlay, boolean playWhenReady, long playbackStartPositionMs) {
    }
    
    private final void switchToPlayer(com.google.android.exoplayer2.Player previousPlayer, com.google.android.exoplayer2.Player newPlayer) {
    }
    
    private final void saveRecentSongToStorage() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/example/android/uamp/media/MusicService$UampCastSessionAvailabilityListener;", "Lcom/google/android/exoplayer2/ext/cast/SessionAvailabilityListener;", "(Lcom/example/android/uamp/media/MusicService;)V", "onCastSessionAvailable", "", "onCastSessionUnavailable", "common_debug"})
    final class UampCastSessionAvailabilityListener implements com.google.android.exoplayer2.ext.cast.SessionAvailabilityListener {
        
        public UampCastSessionAvailabilityListener() {
            super();
        }
        
        /**
         * Called when a Cast session has started and the user wishes to control playback on a
         * remote Cast receiver rather than play audio locally.
         */
        @java.lang.Override()
        public void onCastSessionAvailable() {
        }
        
        /**
         * Called when a Cast session has ended and the user wishes to control playback locally.
         */
        @java.lang.Override()
        public void onCastSessionUnavailable() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/example/android/uamp/media/MusicService$UampQueueNavigator;", "Lcom/google/android/exoplayer2/ext/mediasession/TimelineQueueNavigator;", "mediaSession", "Landroid/support/v4/media/session/MediaSessionCompat;", "(Lcom/example/android/uamp/media/MusicService;Landroid/support/v4/media/session/MediaSessionCompat;)V", "getMediaDescription", "Landroid/support/v4/media/MediaDescriptionCompat;", "player", "Lcom/google/android/exoplayer2/Player;", "windowIndex", "", "common_debug"})
    final class UampQueueNavigator extends com.google.android.exoplayer2.ext.mediasession.TimelineQueueNavigator {
        
        public UampQueueNavigator(@org.jetbrains.annotations.NotNull()
        android.support.v4.media.session.MediaSessionCompat mediaSession) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public android.support.v4.media.MediaDescriptionCompat getMediaDescription(@org.jetbrains.annotations.NotNull()
        com.google.android.exoplayer2.Player player, int windowIndex) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J,\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nH\u0016J\"\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\"\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\"\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/example/android/uamp/media/MusicService$UampPlaybackPreparer;", "Lcom/google/android/exoplayer2/ext/mediasession/MediaSessionConnector$PlaybackPreparer;", "(Lcom/example/android/uamp/media/MusicService;)V", "buildPlaylist", "", "Landroid/support/v4/media/MediaMetadataCompat;", "item", "getSupportedPrepareActions", "", "onCommand", "", "player", "Lcom/google/android/exoplayer2/Player;", "command", "", "extras", "Landroid/os/Bundle;", "cb", "Landroid/os/ResultReceiver;", "onPrepare", "", "playWhenReady", "onPrepareFromMediaId", "mediaId", "onPrepareFromSearch", "query", "onPrepareFromUri", "uri", "Landroid/net/Uri;", "common_debug"})
    final class UampPlaybackPreparer implements com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector.PlaybackPreparer {
        
        public UampPlaybackPreparer() {
            super();
        }
        
        /**
         * UAMP supports preparing (and playing) from search, as well as media ID, so those
         * capabilities are declared here.
         *
         * TODO: Add support for ACTION_PREPARE and ACTION_PLAY, which mean "prepare/play something".
         */
        @java.lang.Override()
        public long getSupportedPrepareActions() {
            return 0L;
        }
        
        @java.lang.Override()
        public void onPrepare(boolean playWhenReady) {
        }
        
        @java.lang.Override()
        public void onPrepareFromMediaId(@org.jetbrains.annotations.NotNull()
        java.lang.String mediaId, boolean playWhenReady, @org.jetbrains.annotations.Nullable()
        android.os.Bundle extras) {
        }
        
        /**
         * This method is used by the Google Assistant to respond to requests such as:
         * - Play Geisha from Wake Up on UAMP
         * - Play electronic music on UAMP
         * - Play music on UAMP
         *
         * For details on how search is handled, see [AbstractMusicSource.search].
         */
        @java.lang.Override()
        public void onPrepareFromSearch(@org.jetbrains.annotations.NotNull()
        java.lang.String query, boolean playWhenReady, @org.jetbrains.annotations.Nullable()
        android.os.Bundle extras) {
        }
        
        @java.lang.Override()
        public void onPrepareFromUri(@org.jetbrains.annotations.NotNull()
        android.net.Uri uri, boolean playWhenReady, @org.jetbrains.annotations.Nullable()
        android.os.Bundle extras) {
        }
        
        @java.lang.Override()
        public boolean onCommand(@org.jetbrains.annotations.NotNull()
        com.google.android.exoplayer2.Player player, @org.jetbrains.annotations.NotNull()
        java.lang.String command, @org.jetbrains.annotations.Nullable()
        android.os.Bundle extras, @org.jetbrains.annotations.Nullable()
        android.os.ResultReceiver cb) {
            return false;
        }
        
        /**
         * Builds a playlist based on a [MediaMetadataCompat].
         *
         * TODO: Support building a playlist by artist, genre, etc...
         *
         * @param item Item to base the playlist on.
         * @return a [List] of [MediaMetadataCompat] objects representing a playlist.
         */
        private final java.util.List<android.support.v4.media.MediaMetadataCompat> buildPlaylist(android.support.v4.media.MediaMetadataCompat item) {
            return null;
        }
    }
    
    /**
     * Listen for notification events.
     */
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/example/android/uamp/media/MusicService$PlayerNotificationListener;", "Lcom/google/android/exoplayer2/ui/PlayerNotificationManager$NotificationListener;", "(Lcom/example/android/uamp/media/MusicService;)V", "onNotificationCancelled", "", "notificationId", "", "dismissedByUser", "", "onNotificationPosted", "notification", "Landroid/app/Notification;", "ongoing", "common_debug"})
    final class PlayerNotificationListener implements com.google.android.exoplayer2.ui.PlayerNotificationManager.NotificationListener {
        
        public PlayerNotificationListener() {
            super();
        }
        
        @java.lang.Override()
        public void onNotificationPosted(int notificationId, @org.jetbrains.annotations.NotNull()
        android.app.Notification notification, boolean ongoing) {
        }
        
        @java.lang.Override()
        public void onNotificationCancelled(int notificationId, boolean dismissedByUser) {
        }
    }
    
    /**
     * Listen for events from ExoPlayer.
     */
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/example/android/uamp/media/MusicService$PlayerEventListener;", "Lcom/google/android/exoplayer2/Player$Listener;", "(Lcom/example/android/uamp/media/MusicService;)V", "onEvents", "", "player", "Lcom/google/android/exoplayer2/Player;", "events", "Lcom/google/android/exoplayer2/Player$Events;", "onPlayerError", "error", "Lcom/google/android/exoplayer2/PlaybackException;", "onPlayerStateChanged", "playWhenReady", "", "playbackState", "", "common_debug"})
    final class PlayerEventListener implements com.google.android.exoplayer2.Player.Listener {
        
        public PlayerEventListener() {
            super();
        }
        
        @java.lang.Override()
        public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
        }
        
        @java.lang.Override()
        public void onEvents(@org.jetbrains.annotations.NotNull()
        com.google.android.exoplayer2.Player player, @org.jetbrains.annotations.NotNull()
        com.google.android.exoplayer2.Player.Events events) {
        }
        
        @java.lang.Override()
        public void onPlayerError(@org.jetbrains.annotations.NotNull()
        com.google.android.exoplayer2.PlaybackException error) {
        }
    }
}