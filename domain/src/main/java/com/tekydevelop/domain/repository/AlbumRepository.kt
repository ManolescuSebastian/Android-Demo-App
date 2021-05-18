package com.tekydevelop.domain.repository

import com.tekydevelop.domain.model.entity.AlbumItem
import kotlinx.coroutines.flow.Flow

interface AlbumRepository {

    suspend fun insertSelectedAlbum(mbid: String, album: String, artist: String, imageUrl: String)
    suspend fun loadAlbumData(): Flow<List<AlbumItem>?>
}