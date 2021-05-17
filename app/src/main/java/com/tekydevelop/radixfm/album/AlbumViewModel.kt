package com.tekydevelop.radixfm.album

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tekydevelop.domain.model.TopAlbumsData
import com.tekydevelop.domain.usecase.TopAlbumsUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class AlbumViewModel() : ViewModel() {

}