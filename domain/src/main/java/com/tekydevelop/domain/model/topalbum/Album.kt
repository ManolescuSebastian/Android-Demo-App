package com.tekydevelop.domain.model.topalbum

import java.io.Serializable

data class Album(
    val name: String,
    val url: String,
    val mbid: String,
    val artist: Artist,
    val attr: Attr,
    val image: List<Image>,
    val playCount: String
) : Serializable

