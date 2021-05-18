package com.tekydevelop.domain.repository

interface AlbumRepository {

    suspend fun insertSelectedAlbum(album: String, artist: String, imageUrl: String)
    suspend fun loadAlbumData()
}