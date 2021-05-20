package com.tekydevelop.radixfm.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tekydevelop.domain.model.search.SearchData
import com.tekydevelop.domain.usecase.SearchAlbumUseCase
import com.tekydevelop.radixfm.base.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class SearchViewModel(private val searchAlbumUseCase: SearchAlbumUseCase) : BaseViewModel() {

    val searchAlbums: LiveData<SearchData> get() = _searchAlbums
    private val _searchAlbums = MutableLiveData<SearchData>()

    fun searchAlbumByName(albumName: String) {
        viewModelScope.launch {
            searchAlbumUseCase.searchAlbum(albumName).onEach {
                _searchAlbums.value = it
            }.handleErrors().collect()
        }
    }
}