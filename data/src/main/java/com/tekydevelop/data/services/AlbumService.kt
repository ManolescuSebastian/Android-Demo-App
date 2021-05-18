package com.tekydevelop.data.services

import com.tekydevelop.data.entity.search.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumService {

    @GET("?method=album.search&format=json")
    suspend fun searchAlbum(@Query("album") albumName: String): SearchResponse
}