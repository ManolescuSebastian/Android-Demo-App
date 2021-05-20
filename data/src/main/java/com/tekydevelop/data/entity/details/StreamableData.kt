package com.tekydevelop.data.entity.details

import com.google.gson.annotations.SerializedName
import com.tekydevelop.data.mapper.DomainMappable
import com.tekydevelop.domain.model.details.Streamable

data class StreamableData(
    @SerializedName("fulltrack")
    val fullTrack: String?,
    @SerializedName("#text")
    val text: String?
) : DomainMappable<Streamable> {
    override fun asDomain(): Streamable {
        return Streamable(fullTrack, text)
    }
}