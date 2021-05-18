package com.tekydevelop.domain.repository

import com.tekydevelop.domain.model.details.AlbumInfoResult
import kotlinx.coroutines.flow.Flow

interface AlbumDetailsRepository {

   suspend fun getAlbumDetails(mbid: String): Flow<AlbumInfoResult?>
}