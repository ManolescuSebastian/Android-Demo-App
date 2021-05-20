package com.tekydevelop.data.repository.album

import android.graphics.Bitmap
import com.tekydevelop.data.db.dao.AlbumsDao
import com.tekydevelop.data.db.entity.AlbumEntity
import com.tekydevelop.data.mapper.DbEntityMapper
import com.tekydevelop.domain.model.entity.AlbumItem
import com.tekydevelop.domain.repository.AlbumRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class AlbumLocalRepo(private val albumsDao: AlbumsDao) : AlbumRepository {
    override suspend fun insertSelectedAlbum(mbid: String, album: String, artist: String, imageUrl: String, resource: Bitmap) {
        withContext(Dispatchers.IO) { albumsDao.insert(AlbumEntity(mbid, album, artist, imageUrl, resource)) }
    }

    override suspend fun loadAlbumData(): Flow<List<AlbumItem>?> {
        return flow {
            emit(withContext(Dispatchers.IO) {
                albumsDao.loadAlbums().map { DbEntityMapper.mapToEntity(it) }
            })
        }
    }

    override suspend fun deleteAlbumById(mbid: String): Flow<Int?> {
        return flow {
            emit(withContext(Dispatchers.IO) {
                albumsDao.deleteById(mbid)
            })
        }
    }
}