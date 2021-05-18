package com.tekydevelop.data.repository.album

import com.tekydevelop.data.services.AlbumService
import com.tekydevelop.domain.model.details.AlbumInfoResult
import com.tekydevelop.domain.repository.AlbumDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AlbumDetailsRepo(private val albumService: AlbumService) : AlbumDetailsRepository {
    override suspend fun getAlbumDetails(mbid: String): Flow<AlbumInfoResult> {
        return flow {
            emit(albumService.getAlbumInfo(mbid).asDomain())
        }
    }
}