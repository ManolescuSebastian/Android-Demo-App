package com.tekydevelop.domain.model.search

import com.tekydevelop.domain.model.topalbum.Image

data class SearchAlbum(
    val name: String,
    val artist: String,
    val url: String,
    val image: List<Image>,
    val streamable: String,
    val mbid: String
)