package com.tekydevelop.data.entity.common

import com.tekydevelop.data.mapper.DomainMappable
import com.tekydevelop.domain.model.topalbum.Attr

data class AttrDTO(
    val rank: String
) : DomainMappable<Attr> {
    override fun asDomain(): Attr {
        return Attr(rank)
    }
}

