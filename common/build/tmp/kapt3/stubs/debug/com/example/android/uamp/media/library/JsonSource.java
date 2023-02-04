package com.example.android.uamp.media.library;

import java.lang.System;

/**
 * Source of [MediaMetadataCompat] objects created from a basic JSON stream.
 *
 * The definition of the JSON is specified in the docs of [JsonMusic] in this file,
 * which is the object representation of it.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0002J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fH\u0096\u0002J\u0011\u0010\r\u001a\u00020\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/example/android/uamp/media/library/JsonSource;", "Lcom/example/android/uamp/media/library/AbstractMusicSource;", "source", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "catalog", "", "Landroid/support/v4/media/MediaMetadataCompat;", "downloadJson", "Lcom/example/android/uamp/media/library/JsonCatalog;", "catalogUri", "iterator", "", "load", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCatalog", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "common_debug"})
public final class JsonSource extends com.example.android.uamp.media.library.AbstractMusicSource {
    private final android.net.Uri source = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.android.uamp.media.library.JsonSource.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ORIGINAL_ARTWORK_URI_KEY = "com.example.android.uamp.JSON_ARTWORK_URI";
    private java.util.List<android.support.v4.media.MediaMetadataCompat> catalog;
    
    public JsonSource(@org.jetbrains.annotations.NotNull()
    android.net.Uri source) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.Iterator<android.support.v4.media.MediaMetadataCompat> iterator() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object load(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    /**
     * Function to connect to a remote URI and download/process the JSON file that corresponds to
     * [MediaMetadataCompat] objects.
     */
    private final java.lang.Object updateCatalog(android.net.Uri catalogUri, kotlin.coroutines.Continuation<? super java.util.List<android.support.v4.media.MediaMetadataCompat>> continuation) {
        return null;
    }
    
    /**
     * Attempts to download a catalog from a given Uri.
     *
     * @param catalogUri URI to attempt to download the catalog form.
     * @return The catalog downloaded, or an empty catalog if an error occurred.
     */
    @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class})
    private final com.example.android.uamp.media.library.JsonCatalog downloadJson(android.net.Uri catalogUri) throws java.io.IOException {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/android/uamp/media/library/JsonSource$Companion;", "", "()V", "ORIGINAL_ARTWORK_URI_KEY", "", "common_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}