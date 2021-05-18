package com.tekydevelop.radixfm.ui.album

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tekydevelop.domain.model.entity.AlbumItem
import com.tekydevelop.domain.usecase.AlbumDbUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AlbumViewModel(private val albumDbUseCase: AlbumDbUseCase) : ViewModel() {

    val albumItems: LiveData<List<AlbumItem>> get() = _albumItems
    private val _albumItems = MutableLiveData<List<AlbumItem>>()

    val error: LiveData<String> get() = _error
    private val _error = MutableLiveData<String>()

    fun loadAlbumsData() {
        viewModelScope.launch(Dispatchers.IO) {
            albumDbUseCase.loadAlbums().onStart {

            }.catch { e ->
                withContext(Dispatchers.Main) {
                    _error.value = e.localizedMessage
                }
            }.collect {
                withContext(Dispatchers.Main) {
                    _albumItems.value = it
                }
            }
        }
    }
}