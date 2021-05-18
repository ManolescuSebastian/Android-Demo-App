package com.tekydevelop.data.entity.search

import com.google.gson.annotations.SerializedName
import com.tekydevelop.data.mapper.DomainMappable
import com.tekydevelop.domain.model.search.AlbumMatches

data class AlbumMatchesDTO(
    @SerializedName("album")
    val album: List<SearchAlbumDTO>
): DomainMappable<AlbumMatches> {
    override fun asDomain(): AlbumMatches {
        return AlbumMatches(album.map { it.asDomain() })
    }
}