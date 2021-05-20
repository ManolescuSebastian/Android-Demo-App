package com.tekydevelop.domain.usecase

import android.graphics.Bitmap
import com.tekydevelop.domain.model.entity.AlbumItem
import com.tekydevelop.domain.repository.AlbumRepository
import kotlinx.coroutines.flow.Flow

class AlbumDbUseCase(private val albumRepository: AlbumRepository) {

    suspend fun insertAlbum(mbid: String, album: String, artist: String, imageUrl: String, resource: Bitmap) {
        albumRepository.insertSelectedAlbum(mbid, album, artist, imageUrl, resource)
    }

    suspend fun loadAlbums(): Flow<List<AlbumItem>?> {
        return albumRepository.loadAlbumData()
    }

    suspend fun deleteAlbumById(mbid: String): Flow<Int?>{
       return albumRepository.deleteAlbumById(mbid)
    }
}