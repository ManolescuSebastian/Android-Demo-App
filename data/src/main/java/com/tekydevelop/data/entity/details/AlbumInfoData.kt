package com.tekydevelop.data.entity.details

import com.google.gson.annotations.SerializedName
import com.tekydevelop.data.common.DomainMappable
import com.tekydevelop.data.entity.common.ImageDTO
import com.tekydevelop.domain.model.details.AlbumInfo

data class AlbumInfoData(
    val listeners: String,
    @SerializedName("playcount")
    val playCount: String,
    val artist: String,
    val image: List<ImageDTO>,
    val url: String,
    val tags: TagsData,
    val wiki: WikiData?,
    val name: String,
    val tracks: TracksData
) : DomainMappable<AlbumInfo> {
    override fun asDomain(): AlbumInfo {
        return AlbumInfo(listeners, playCount, artist, image.map { it.asDomain() }, url, tags.asDomain(), wiki?.asDomain(), name, tracks.asDomain())
    }
}