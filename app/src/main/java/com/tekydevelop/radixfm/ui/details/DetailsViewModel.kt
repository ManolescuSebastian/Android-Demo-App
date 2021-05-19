package com.tekydevelop.radixfm.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tekydevelop.domain.model.details.AlbumInfo
import com.tekydevelop.domain.usecase.AlbumDetailsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailsViewModel(private val albumDetailsUseCase: AlbumDetailsUseCase) : ViewModel() {

    val albumInfoResult: LiveData<AlbumInfo> get() = _albumInfoResult
    private val _albumInfoResult = MutableLiveData<AlbumInfo>()

    val error: LiveData<String> get() = _error
    private val _error = MutableLiveData<String>()

    fun getAlbumDetails(mbid: String, online: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            albumDetailsUseCase.getAlbumDetails(mbid, online).onStart {

            }.catch { e ->
                withContext(Dispatchers.Main) {
                    _error.value = e.localizedMessage
                }
            }.collect {
                withContext(Dispatchers.Main) {
                    _albumInfoResult.value = it
                }
            }
        }
    }
}