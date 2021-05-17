package com.tekydevelop.data.entity.topalbum

import com.tekydevelop.data.common.DomainMappable
import com.tekydevelop.domain.model.topalbum.AlbumAttr

data class AlbumAttrDTO(
    val rank: String
) : DomainMappable<AlbumAttr> {
    override fun asDomain(): AlbumAttr {
        return AlbumAttr(rank)
    }
}

