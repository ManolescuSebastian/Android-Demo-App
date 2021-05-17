package com.tekydevelop.radixfm.di

import com.tekydevelop.radixfm.album.AlbumViewModel
import com.tekydevelop.radixfm.details.AlbumDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { AlbumViewModel() }
    viewModel { AlbumDetailsViewModel(get()) }
}