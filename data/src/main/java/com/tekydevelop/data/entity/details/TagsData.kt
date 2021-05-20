package com.tekydevelop.data.entity.details

import com.tekydevelop.data.mapper.DomainMappable
import com.tekydevelop.domain.model.details.Tags

data class TagsData(
    val tag: List<TagData>?
) : DomainMappable<Tags?> {
    override fun asDomain(): Tags? {
        return tag?.map { it.asDomain() }?.let { Tags(it) }
    }
}