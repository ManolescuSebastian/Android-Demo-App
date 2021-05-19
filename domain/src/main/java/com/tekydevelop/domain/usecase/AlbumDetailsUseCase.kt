package com.tekydevelop.domain.usecase

import com.tekydevelop.domain.model.details.AlbumInfo
import com.tekydevelop.domain.repository.AlbumDetailsRepository
import kotlinx.coroutines.flow.Flow

class AlbumDetailsUseCase(private val albumDetailsRepository: AlbumDetailsRepository) {

    suspend fun getAlbumDetails(mbid: String, online: Boolean): Flow<AlbumInfo?> {
        return albumDetailsRepository.getAlbumDetails(mbid, online)
    }
}