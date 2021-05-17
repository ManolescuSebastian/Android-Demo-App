package com.tekydevelop.data.entity.search

import com.google.gson.annotations.SerializedName
import com.tekydevelop.data.common.DomainMappable
import com.tekydevelop.domain.model.search.SearchResultData

class SearchResult(
    @SerializedName("opensearch:Query")
    val query: OpenSearchDTO,
    @SerializedName("opensearch:totalResults")
    val totalResults: String,
    @SerializedName("opensearch:startIndex")
    val startIndex: String,
    @SerializedName("opensearch:itemsPerPage")
    val itemsPerPage: String,
    @SerializedName("albummatches")
    val albumMatches: AlbumMatchesDTO,
    @SerializedName("@attr")
    val attrDTO: SearchAttrDTO
) : DomainMappable<SearchResultData> {
    override fun asDomain(): SearchResultData {
        return SearchResultData(query.asDomain(), totalResults, startIndex, itemsPerPage, albumMatches.asDomain(), attrDTO.asDomain())
    }
}