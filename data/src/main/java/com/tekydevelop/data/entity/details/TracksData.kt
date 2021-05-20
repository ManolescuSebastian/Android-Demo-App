package com.tekydevelop.data.entity.details

import com.tekydevelop.data.mapper.DomainMappable
import com.tekydevelop.domain.model.details.Tracks

data class TracksData(
    val track: List<TrackData>?
): DomainMappable<Tracks?> {
    override fun asDomain(): Tracks? {
        return track?.map { it.asDomain() }?.let { Tracks(it) }
    }
}