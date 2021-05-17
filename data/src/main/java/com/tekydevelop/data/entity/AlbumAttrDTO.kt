package com.tekydevelop.data.entity

import com.tekydevelop.data.common.DomainMappable
import com.tekydevelop.domain.model.AlbumAttr

data class AlbumAttrDTO(
    val rank: String
) : DomainMappable<AlbumAttr> {
    override fun asDomain(): AlbumAttr {
        return AlbumAttr(rank)
    }
}

