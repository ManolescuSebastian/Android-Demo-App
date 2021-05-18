package com.tekydevelop.domain.model.search

class SearchResultData(
    val query: OpenSearch,
    val totalResults: String,
    val startIndex: String,
    val itemsPerPage: String,
    val albumMatches: AlbumMatches,
    val attr: SearchAttr
)