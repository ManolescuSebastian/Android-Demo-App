package com.tekydevelop.data.db.entity

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "AlbumEntity")
data class AlbumEntity(
    @PrimaryKey
    val mbid: String,
    val album: String,
    val artist: String,
    val imageUrl: String,
    val albumPhoto: Bitmap
)