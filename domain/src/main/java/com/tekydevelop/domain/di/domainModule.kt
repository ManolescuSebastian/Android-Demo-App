package com.tekydevelop.domain.di

import com.tekydevelop.domain.usecase.TopAlbumsUseCase
import org.koin.dsl.module

val domainModule = module {

    factory { TopAlbumsUseCase(get()) }
}