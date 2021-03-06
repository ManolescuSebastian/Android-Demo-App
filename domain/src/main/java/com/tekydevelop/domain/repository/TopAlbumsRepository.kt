package com.tekydevelop.domain.repository

import com.tekydevelop.domain.model.topalbum.TopAlbumsData
import kotlinx.coroutines.flow.Flow

interface TopAlbumsRepository {

    suspend fun getTopAlbums(): Flow<TopAlbumsData?>
}