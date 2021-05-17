package com.tekydevelop.domain.model

import java.io.Serializable

data class Album(
    val name: String,
    val url: String,
    val mbid: String,
    val artist: Artist,
    val attr: AlbumAttr,
    val image: List<Image>,
    val playCount: String
) : Serializable

