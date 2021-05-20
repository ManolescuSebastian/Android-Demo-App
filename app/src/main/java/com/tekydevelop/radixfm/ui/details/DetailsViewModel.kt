package com.tekydevelop.radixfm.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tekydevelop.domain.model.details.AlbumInfo
import com.tekydevelop.domain.usecase.AlbumDetailsUseCase
import com.tekydevelop.radixfm.base.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class DetailsViewModel(private val albumDetailsUseCase: AlbumDetailsUseCase) : BaseViewModel() {

    val albumInfoResult: LiveData<AlbumInfo> get() = _albumInfoResult
    private val _albumInfoResult = MutableLiveData<AlbumInfo>()

    fun getAlbumDetails(mbid: String, online: Boolean) {
        viewModelScope.launch {
            albumDetailsUseCase.getAlbumDetails(mbid, online)
                .onEach {
                    _albumInfoResult.value = it
                }.handleErrors().collect()
        }
    }
}