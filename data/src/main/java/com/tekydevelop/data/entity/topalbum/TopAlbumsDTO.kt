package com.tekydevelop.data.entity.topalbum

import com.google.gson.annotations.SerializedName
import com.tekydevelop.data.mapper.DomainMappable
import com.tekydevelop.domain.model.topalbum.TopAlbums

data class TopAlbumsDTO(
    @SerializedName("album")
    val albumDTO: List<AlbumDTO>,
    @SerializedName("@attr")
    val topAlbumAttrDTO: TopAlbumAttrDTO
) : DomainMappable<TopAlbums> {
    override fun asDomain(): TopAlbums {
        return TopAlbums(albumDTO.map { it.asDomain() }, topAlbumAttrDTO.asDomain())
    }
}