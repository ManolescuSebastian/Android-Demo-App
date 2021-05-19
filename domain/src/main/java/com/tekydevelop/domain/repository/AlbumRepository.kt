package com.tekydevelop.domain.repository

import android.graphics.Bitmap
import com.tekydevelop.domain.model.entity.AlbumItem
import kotlinx.coroutines.flow.Flow

interface AlbumRepository {

    suspend fun insertSelectedAlbum(mbid: String, album: String, artist: String, imageUrl: String, resource: Bitmap)
    suspend fun loadAlbumData(): Flow<List<AlbumItem>?>
}