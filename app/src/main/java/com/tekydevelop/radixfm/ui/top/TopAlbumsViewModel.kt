package com.tekydevelop.radixfm.ui.top

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tekydevelop.domain.model.topalbum.TopAlbumsData
import com.tekydevelop.domain.usecase.AlbumDbUseCase
import com.tekydevelop.domain.usecase.TopAlbumsUseCase
import com.tekydevelop.radixfm.base.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class TopAlbumsViewModel(private val topAlbumsUseCase: TopAlbumsUseCase, private val albumDbUseCase: AlbumDbUseCase) : BaseViewModel() {

    val topAlbums: LiveData<TopAlbumsData> get() = _topAlbums
    private val _topAlbums = MutableLiveData<TopAlbumsData>()

    fun getTopAlbumData() {
        viewModelScope.launch {
            topAlbumsUseCase.getTopAlbums().onEach {
                _topAlbums.value = it
            }.handleErrors().collect()
        }
    }

    fun insertSelectedAlbum(mbid: String, album: String, artist: String, imageUrl: String, resource: Bitmap) {
        viewModelScope.launch {
            albumDbUseCase.insertAlbum(mbid, album, artist, imageUrl, resource)
        }
    }
}