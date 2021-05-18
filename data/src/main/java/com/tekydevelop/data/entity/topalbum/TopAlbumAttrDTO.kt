package com.tekydevelop.data.entity.topalbum

import com.tekydevelop.data.mapper.DomainMappable
import com.tekydevelop.domain.model.topalbum.TopAlbumAttr

data class TopAlbumAttrDTO(
    val page: String,
    val perPage: String,
    val user: String,
    val total: String,
    val totalPages: String
) : DomainMappable<TopAlbumAttr> {
    override fun asDomain(): TopAlbumAttr {
        return TopAlbumAttr(page, perPage, user, total, totalPages)
    }
}
