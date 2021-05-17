package com.tekydevelop.data.entity.topalbum

import com.tekydevelop.data.common.DomainMappable
import com.tekydevelop.domain.model.topalbum.Attr

data class AttrDTO(
    val page: String,
    val perPage: String,
    val user: String,
    val total: String,
    val totalPages: String
) : DomainMappable<Attr> {
    override fun asDomain(): Attr {
        return Attr(page, perPage, user, total, totalPages)
    }
}
