package com.tekydevelop.data.entity.topalbum

import com.google.gson.annotations.SerializedName
import com.tekydevelop.data.mapper.DomainMappable
import com.tekydevelop.data.entity.common.AttrDTO
import com.tekydevelop.data.entity.common.ArtistDTO
import com.tekydevelop.data.entity.common.ImageDTO
import com.tekydevelop.domain.model.topalbum.Album

data class AlbumDTO(
    val name: String,
    val url: String,
    val mbid: String,
    @SerializedName("artist")
    val artistDTO: ArtistDTO,
    @SerializedName("@attr")
    val attrDTO: AttrDTO,
    @SerializedName("image")
    val imageDTO: List<ImageDTO>,
    @SerializedName("playcount")
    val playCount: String
) : DomainMappable<Album> {
    override fun asDomain(): Album {
        return Album(name, url, mbid, artistDTO.asDomain(), attrDTO.asDomain(), imageDTO.map { it.asDomain() }, playCount)
    }
}

