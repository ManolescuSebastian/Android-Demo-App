package com.tekydevelop.domain.model.details

import com.tekydevelop.domain.model.topalbum.Image

data class AlbumInfo(
    val listeners: String,
    val playCount: String,
    val artist: String,
    val image: List<Image>,
    val url: String,
    val tags: Tags,
    val wiki: Wiki?,
    val name: String,
    val tracks: Tracks
)