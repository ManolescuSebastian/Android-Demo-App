package com.tekydevelop.domain.repository


import com.tekydevelop.domain.model.search.SearchData
import kotlinx.coroutines.flow.Flow

interface SearchRepository {

    suspend fun searchAlbum(albumName: String): Flow<SearchData?>
}