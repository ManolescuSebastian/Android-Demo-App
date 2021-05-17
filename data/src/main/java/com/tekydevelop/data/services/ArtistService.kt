package com.tekydevelop.data.services

import com.tekydevelop.data.entity.topalbum.TopAlbumsResponse
import retrofit2.http.GET

interface ArtistService {

    //todo remove the api key and add it in interceptor
    @GET(" ?method=user.gettopalbums&user=rj&api_key=b3411df1960d46dbc4736cb8c32544e9&format=json")
    suspend fun getTopAlbums(): TopAlbumsResponse?
}