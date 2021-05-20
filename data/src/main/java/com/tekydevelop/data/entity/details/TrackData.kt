package com.tekydevelop.data.entity.details

import com.tekydevelop.data.entity.common.ArtistDTO
import com.tekydevelop.data.mapper.DomainMappable
import com.tekydevelop.domain.model.details.Track

data class TrackData(
    val artist: ArtistDTO?,
    val duration: Int?,
    val url: String?,
    val name: String?,
    val streamable: StreamableData?
) : DomainMappable<Track> {
    override fun asDomain(): Track {
        return Track(artist?.asDomain(), duration, url, name, streamable?.asDomain())
    }
}