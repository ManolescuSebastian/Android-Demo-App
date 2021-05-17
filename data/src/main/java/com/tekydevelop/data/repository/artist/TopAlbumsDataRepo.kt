package com.tekydevelop.data.repository.artist

import com.tekydevelop.data.services.ArtistService
import com.tekydevelop.domain.model.TopAlbumsData
import com.tekydevelop.domain.repository.TopAlbumsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TopAlbumsDataRepo(private val artistService: ArtistService) : TopAlbumsRepository {
    override suspend fun getTopAlbums(): Flow<TopAlbumsData?> {
        return flow {
            emit(artistService.getTopAlbums()?.asDomain())
        }
    }
}