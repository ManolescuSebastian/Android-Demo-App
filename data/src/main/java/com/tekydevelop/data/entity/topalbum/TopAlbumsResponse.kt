package com.tekydevelop.data.entity.topalbum

import com.google.gson.annotations.SerializedName
import com.tekydevelop.data.common.DomainMappable
import com.tekydevelop.domain.model.topalbum.TopAlbumsData

data class TopAlbumsResponse(
    @SerializedName("topalbums")
    val topAlbumsDTO: TopAlbumsDTO
) : DomainMappable<TopAlbumsData> {
    override fun asDomain(): TopAlbumsData {
        return TopAlbumsData(topAlbumsDTO.asDomain())
    }
}