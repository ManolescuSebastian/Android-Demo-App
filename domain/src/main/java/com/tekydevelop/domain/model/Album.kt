package com.tekydevelop.domain.model

data class Album(
    val name: String,
    val url: String,
    val mbid: String,
    val artist: Artist,
    val attr: AlbumAttr,
    val image: List<Image>,
    val playCount: String
)

