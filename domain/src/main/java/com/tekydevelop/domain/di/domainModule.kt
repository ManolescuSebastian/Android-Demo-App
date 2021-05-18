package com.tekydevelop.domain.di

import com.tekydevelop.domain.usecase.AlbumDbUseCase
import com.tekydevelop.domain.usecase.AlbumDetailsUseCase
import com.tekydevelop.domain.usecase.SearchAlbumUseCase
import com.tekydevelop.domain.usecase.TopAlbumsUseCase
import org.koin.dsl.module

val domainModule = module {

    factory { TopAlbumsUseCase(get()) }
    factory { SearchAlbumUseCase(get()) }
    factory { AlbumDetailsUseCase(get()) }

    factory { AlbumDbUseCase(get()) }
}