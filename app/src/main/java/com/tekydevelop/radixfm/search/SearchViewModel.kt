package com.tekydevelop.radixfm.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tekydevelop.domain.model.search.SearchData
import com.tekydevelop.domain.usecase.SearchAlbumUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class SearchViewModel(private val searchAlbumUseCase: SearchAlbumUseCase) : ViewModel() {

    val searchAlbums: LiveData<SearchData> get() = _searchAlbums
    private val _searchAlbums = MutableLiveData<SearchData>()

    val error: LiveData<String> get() = _error
    private val _error = MutableLiveData<String>()

    fun searchAlbumByName(albumName: String) {
        viewModelScope.launch {
            searchAlbumUseCase.searchAlbum(albumName).onStart {
            }.catch { e ->
                _error.value = e.localizedMessage
            }.collect {
                _searchAlbums.value = it
            }
        }
    }
}