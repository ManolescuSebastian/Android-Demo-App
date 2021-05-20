package com.tekydevelop.data.entity.details

import com.tekydevelop.data.mapper.DomainMappable
import com.tekydevelop.domain.model.details.Wiki

data class WikiData(
    val published: String?,
    val content: String?,
    val summary: String?
) : DomainMappable<Wiki> {
    override fun asDomain(): Wiki {
        return Wiki(published, content, summary)
    }
}
