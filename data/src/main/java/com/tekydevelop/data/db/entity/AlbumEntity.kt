package com.tekydevelop.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "AlbumEntity")
data class AlbumEntity (
    @PrimaryKey
    @ColumnInfo(name= "mbid") val mbid: String,
    @ColumnInfo(name = "album") val album: String,
    @ColumnInfo(name = "artist") val artist: String,
    @ColumnInfo(name = "image_url") val imageUrl: String
)