package com.tekydevelop.domain.model.search

data class OpenSearch(
    val text: String,
    val role: String,
    val searchTerms: String,
    val startPage:String
)
