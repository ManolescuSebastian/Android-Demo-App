package com.tekydevelop.data.repository.album

import com.tekydevelop.data.db.dao.AlbumsDao
import com.tekydevelop.data.db.entity.AlbumEntity
import com.tekydevelop.data.mapper.DbEntityMapper
import com.tekydevelop.domain.model.entity.AlbumItem
import com.tekydevelop.domain.repository.AlbumRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AlbumLocalRepo(private val albumsDao: AlbumsDao) : AlbumRepository {
    override suspend fun insertSelectedAlbum(mbid: String, album: String, artist: String, imageUrl: String) {
        albumsDao.insert(AlbumEntity(mbid, album, artist, imageUrl))
    }

    override suspend fun loadAlbumData(): Flow<List<AlbumItem>?> {
        return flow {
            emit(albumsDao.loadAlbums().map { DbEntityMapper.mapToEntity(it) })
        }
    }
}