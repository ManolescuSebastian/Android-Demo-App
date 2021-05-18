package com.tekydevelop.data.entity.search

import com.google.gson.annotations.SerializedName
import com.tekydevelop.data.mapper.DomainMappable
import com.tekydevelop.domain.model.search.SearchAttr

data class SearchAttrDTO(
    @SerializedName("for")
    val forData: String
): DomainMappable<SearchAttr> {
    override fun asDomain(): SearchAttr {
        return SearchAttr(forData)
    }
}
