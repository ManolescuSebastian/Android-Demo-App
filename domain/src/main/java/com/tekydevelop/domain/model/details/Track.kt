package com.tekydevelop.domain.model.details

import com.tekydevelop.domain.model.topalbum.Artist

data class Track(
    val artist: Artist?,
    val duration: Int?,
    val url: String?,
    val name: String?,
    val streamable: Streamable?
)