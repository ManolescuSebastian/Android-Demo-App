package com.tekydevelop.radixfm.di

import com.tekydevelop.radixfm.album.AlbumViewModel
import com.tekydevelop.radixfm.details.DetailsViewModel
import com.tekydevelop.radixfm.search.SearchViewModel
import com.tekydevelop.radixfm.top.TopAlbumsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { AlbumViewModel() }
    viewModel { TopAlbumsViewModel(get(), get()) }
    viewModel { SearchViewModel(get()) }
    viewModel { DetailsViewModel(get()) }
}