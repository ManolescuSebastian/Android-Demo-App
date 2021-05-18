package com.tekydevelop.data.entity.search

import com.google.gson.annotations.SerializedName
import com.tekydevelop.data.mapper.DomainMappable
import com.tekydevelop.domain.model.search.SearchData

class SearchResponse(
    @SerializedName("results")
    val searchResult: SearchResult
): DomainMappable<SearchData> {
    override fun asDomain(): SearchData {
        return SearchData(searchResult.asDomain())
    }
}
