package com.tekydevelop.data.repository.album

import com.tekydevelop.data.db.dao.AlbumsDao
import com.tekydevelop.data.db.entity.AlbumEntity
import com.tekydevelop.domain.repository.AlbumRepository

class AlbumLocalRepo(private val albumsDao: AlbumsDao) : AlbumRepository {
    override suspend fun insertSelectedAlbum(album: String, artist: String, imageUrl: String) {
        albumsDao.insert(AlbumEntity(album, artist, imageUrl))
    }

    override suspend fun loadAlbumData() {

    }
}