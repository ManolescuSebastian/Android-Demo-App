package com.tekydevelop.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tekydevelop.data.db.dao.AlbumsDao
import com.tekydevelop.data.db.entity.AlbumEntity

@Database(entities = [AlbumEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun albumsDao(): AlbumsDao
}