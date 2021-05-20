package com.tekydevelop.data.entity.details

import com.tekydevelop.data.mapper.DomainMappable
import com.tekydevelop.domain.model.details.Tag

data class TagData(
    val name: String?,
    val url: String?
) : DomainMappable<Tag> {
    override fun asDomain(): Tag {
        return Tag(name, url)
    }
}