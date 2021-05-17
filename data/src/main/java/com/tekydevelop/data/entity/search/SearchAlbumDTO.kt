package com.tekydevelop.data.entity.search

import com.tekydevelop.data.common.DomainMappable
import com.tekydevelop.data.entity.topalbum.ImageDTO
import com.tekydevelop.domain.model.search.SearchAlbum

data class SearchAlbumDTO(
    val name: String,
    val artist: String,
    val url: String,
    val image: List<ImageDTO>,
    val streamable: String,
    val mbid: String
) : DomainMappable<SearchAlbum> {
    override fun asDomain(): SearchAlbum {
        return SearchAlbum(name, artist, url, image.map { it.asDomain() }, streamable, mbid)
    }
}