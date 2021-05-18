package com.tekydevelop.data.entity.search

import com.google.gson.annotations.SerializedName
import com.tekydevelop.data.mapper.DomainMappable
import com.tekydevelop.domain.model.search.OpenSearch

data class OpenSearchDTO(
    @SerializedName("#text")
    val text: String,
    val role: String,
    val searchTerms: String,
    val startPage:String
): DomainMappable<OpenSearch> {
    override fun asDomain(): OpenSearch {
        return OpenSearch(text, role, searchTerms, startPage)
    }
}
