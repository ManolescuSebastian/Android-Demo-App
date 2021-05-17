package com.tekydevelop.data.entity.topalbum

import com.google.gson.annotations.SerializedName
import com.tekydevelop.data.common.DomainMappable
import com.tekydevelop.domain.model.topalbum.Image

data class ImageDTO(
    val size: String,
    @SerializedName("#text")
    val url: String
) : DomainMappable<Image> {
    override fun asDomain(): Image {
        return Image(size, url)
    }
}