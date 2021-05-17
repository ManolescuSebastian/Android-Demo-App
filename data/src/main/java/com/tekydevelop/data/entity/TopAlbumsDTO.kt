package com.tekydevelop.data.entity

import com.google.gson.annotations.SerializedName
import com.tekydevelop.data.common.DomainMappable
import com.tekydevelop.domain.model.TopAlbums

data class TopAlbumsDTO(
    @SerializedName("album")
    val albumDTO: List<AlbumDTO>,
    @SerializedName("@attr")
    val attrDTO: AttrDTO
) : DomainMappable<TopAlbums> {
    override fun asDomain(): TopAlbums {
        return TopAlbums(albumDTO.map { it.asDomain() }, attrDTO.asDomain())
    }
}