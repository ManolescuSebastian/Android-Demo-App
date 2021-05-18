package com.tekydevelop.domain.usecase

import com.tekydevelop.domain.model.entity.AlbumItem
import com.tekydevelop.domain.repository.AlbumRepository
import kotlinx.coroutines.flow.Flow

class AlbumDbUseCase(private val albumRepository: AlbumRepository) {

    suspend fun insertAlbum(mbid: String, album: String, artist: String, imageUrl: String) {
        albumRepository.insertSelectedAlbum(mbid, album, artist, imageUrl)
    }

    suspend fun loadAlbums(): Flow<List<AlbumItem>?> {
        return albumRepository.loadAlbumData()
    }
}