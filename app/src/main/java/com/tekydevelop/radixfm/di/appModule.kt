package com.tekydevelop.radixfm.di

import com.tekydevelop.radixfm.ui.album.AlbumViewModel
import com.tekydevelop.radixfm.ui.details.DetailsViewModel
import com.tekydevelop.radixfm.ui.search.SearchViewModel
import com.tekydevelop.radixfm.ui.top.TopAlbumsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { AlbumViewModel(get()) }
    viewModel { TopAlbumsViewModel(get(), get()) }
    viewModel { SearchViewModel(get()) }
    viewModel { DetailsViewModel(get()) }
}