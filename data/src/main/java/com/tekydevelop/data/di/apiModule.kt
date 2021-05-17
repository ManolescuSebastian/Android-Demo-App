package com.tekydevelop.data.di

import android.app.Application
import androidx.constraintlayout.solver.Cache
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.tekydevelop.data.BuildConfig
import com.tekydevelop.data.repository.artist.TopAlbumsDataRepo
import com.tekydevelop.data.repository.search.SearchDataRepo
import com.tekydevelop.data.services.AlbumService
import com.tekydevelop.data.services.ArtistService
import com.tekydevelop.domain.repository.SearchRepository
import com.tekydevelop.domain.repository.TopAlbumsRepository
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val apiModule = module {

    fun provideCache(application: Application): okhttp3.Cache {
        val cacheSize = 10 * 1024 * 1024
        return okhttp3.Cache(application.cacheDir, cacheSize.toLong())
    }

    fun provideHttpClient(cache: okhttp3.Cache): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
            .cache(cache)

        return okHttpClientBuilder.build()
    }

    fun provideGson(): Gson {
        return GsonBuilder().setLenient().create()
    }


    fun provideRetrofit(factory: Gson, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(factory))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(client)
            .build()
    }

    single { provideCache(androidApplication()) }
    single { provideHttpClient(get()) }
    single { provideGson() }
    single { provideRetrofit(get(), get()) }

    single<ArtistService> { get<Retrofit>().create(ArtistService::class.java) }
    single<AlbumService> { get<Retrofit>().create(AlbumService::class.java) }

    single<TopAlbumsRepository> { TopAlbumsDataRepo(get()) }
    single<SearchRepository> { SearchDataRepo(get()) }
}