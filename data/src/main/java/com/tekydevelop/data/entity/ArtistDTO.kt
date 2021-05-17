package com.tekydevelop.data.entity

import com.tekydevelop.data.common.DomainMappable
import com.tekydevelop.domain.model.Artist

data class ArtistDTO(
    val url: String,
    val name: String,
    val mbid: String
) : DomainMappable<Artist> {
    override fun asDomain(): Artist {
        return Artist(url, name, mbid)
    }
}