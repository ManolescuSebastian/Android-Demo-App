package com.tekydevelop.data.db.dao

import androidx.room.*
import com.tekydevelop.data.db.entity.AlbumEntity

@Dao
interface AlbumsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(album: AlbumEntity)

    @Update
    fun update(album: AlbumEntity)

    @Query(value = "SELECT * FROM AlbumEntity LIMIT 50")
    fun loadAlbums(): List<AlbumEntity>

    @Query(value = "SELECT * FROM AlbumEntity WHERE mbid=:mbid")
    fun findAlbumById(mbid: String): AlbumEntity

    @Query(value ="DELETE FROM AlbumEntity WHERE mbid=:mbid")
    fun deleteById(mbid: String): Int

    @Query(value = "DELETE FROM AlbumEntity")
    fun deleteAlbums()
}