package com.tekydevelop.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tekydevelop.data.db.dao.AlbumsDao
import com.tekydevelop.data.db.entity.AlbumEntity
import com.tekydevelop.data.util.Converter

@Database(entities = [AlbumEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun albumsDao(): AlbumsDao
}