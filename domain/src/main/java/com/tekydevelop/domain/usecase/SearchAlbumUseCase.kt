package com.tekydevelop.domain.usecase

import com.tekydevelop.domain.model.search.SearchData
import com.tekydevelop.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow

class SearchAlbumUseCase(private val searchRepository: SearchRepository) {

    suspend fun searchAlbum(albumName: String): Flow<SearchData?> {
        return searchRepository.searchAlbum(albumName)
    }
}