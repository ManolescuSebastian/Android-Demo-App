package com.tekydevelop.domain.usecase

import com.tekydevelop.domain.model.TopAlbumsData
import com.tekydevelop.domain.repository.TopAlbumsRepository
import kotlinx.coroutines.flow.Flow

class TopAlbumsUseCase(private val topAlbumsRepository: TopAlbumsRepository) {

    suspend fun getTopAlbums(): Flow<TopAlbumsData?> {
        return topAlbumsRepository.getTopAlbums()
    }
}