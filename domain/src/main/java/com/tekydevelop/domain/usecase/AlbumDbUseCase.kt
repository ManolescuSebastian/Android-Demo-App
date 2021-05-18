package com.tekydevelop.domain.usecase

import com.tekydevelop.domain.repository.AlbumRepository

class AlbumDbUseCase(private val albumRepository: AlbumRepository) {

    suspend fun insertAlbum(album: String, artist: String, imageUrl: String) {
        albumRepository.insertSelectedAlbum(album, artist, imageUrl)
    }
}