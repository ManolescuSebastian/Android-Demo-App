package com.tekydevelop.domain.usecase

import com.tekydevelop.domain.model.details.AlbumInfoResult
import com.tekydevelop.domain.repository.AlbumDetailsRepository
import kotlinx.coroutines.flow.Flow

class AlbumDetailsUseCase(private val albumDetailsRepository: AlbumDetailsRepository) {

    suspend fun getAlbumDetails(mbid: String): Flow<AlbumInfoResult?> {
        return albumDetailsRepository.getAlbumDetails(mbid)
    }
}