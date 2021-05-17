package com.tekydevelop.data.services

import com.tekydevelop.data.entity.search.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumService {

    @GET("?method=album.search&api_key=b3411df1960d46dbc4736cb8c32544e9&format=json")
    suspend fun searchAlbum(@Query("album") albumName: String): SearchResponse
}