package com.tekydevelop.data.di

import androidx.room.Room
import com.tekydevelop.data.db.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dbModule = module {

    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "radix_fm_database.db").fallbackToDestructiveMigration().build()
    }

    single { get<AppDatabase>().albumsDao() }
}
