package com.tekydevelop.data.entity.details

import com.tekydevelop.data.mapper.DomainMappable
import com.tekydevelop.domain.model.details.AlbumInfoResult

data class AlbumInfoResponse(
    val album: AlbumInfoData
): DomainMappable<AlbumInfoResult> {
    override fun asDomain(): AlbumInfoResult {
       return AlbumInfoResult(album.asDomain())
    }
}
