package com.tekydevelop.data.services

import com.tekydevelop.data.entity.topalbum.TopAlbumsResponse
import retrofit2.http.GET

interface ArtistService {

    @GET(" ?method=user.gettopalbums&user=rj&format=json")
    suspend fun getTopAlbums(): TopAlbumsResponse?
}