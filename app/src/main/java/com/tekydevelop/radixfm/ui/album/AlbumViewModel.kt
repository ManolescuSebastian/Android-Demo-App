package com.tekydevelop.radixfm.ui.album

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tekydevelop.domain.model.entity.AlbumItem
import com.tekydevelop.domain.usecase.AlbumDbUseCase
import com.tekydevelop.radixfm.base.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class AlbumViewModel(private val albumDbUseCase: AlbumDbUseCase) : BaseViewModel() {

    val albumItems: LiveData<List<AlbumItem>> get() = _albumItems
    private val _albumItems = MutableLiveData<List<AlbumItem>>()

    val deletedItem: LiveData<Int> get() = _deletedItem
    private val _deletedItem = MutableLiveData<Int>()

    fun loadAlbumsData() {
        viewModelScope.launch {
            albumDbUseCase.loadAlbums().onEach {
                _albumItems.value = it
            }.handleErrors().collect()
        }
    }

    fun deleteAlbumById(mbid: String) {
        viewModelScope.launch {
            albumDbUseCase.deleteAlbumById(mbid).onEach{
                _deletedItem.value = it
            }.handleErrors().collect()
        }

    }
}