package com.tekydevelop.data.repository.search

import com.tekydevelop.data.services.AlbumService
import com.tekydevelop.domain.model.search.SearchData
import com.tekydevelop.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchDataRepo(private val albumService: AlbumService) : SearchRepository {
    override suspend fun searchAlbum(albumName: String): Flow<SearchData?> {
        return flow {
            emit(albumService.searchAlbum(albumName).asDomain())
        }
    }
}