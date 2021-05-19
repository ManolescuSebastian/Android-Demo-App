package com.tekydevelop.domain.repository

import com.tekydevelop.domain.model.details.AlbumInfo
import kotlinx.coroutines.flow.Flow

interface AlbumDetailsRepository {

   suspend fun getAlbumDetails(mbid: String, online: Boolean): Flow<AlbumInfo?>
}