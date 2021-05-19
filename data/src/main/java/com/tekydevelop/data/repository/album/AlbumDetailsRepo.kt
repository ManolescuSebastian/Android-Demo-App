package com.tekydevelop.data.repository.album

import com.tekydevelop.data.db.dao.AlbumsDao
import com.tekydevelop.data.services.AlbumService
import com.tekydevelop.domain.model.details.AlbumInfo
import com.tekydevelop.domain.repository.AlbumDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AlbumDetailsRepo(private val albumService: AlbumService, private val albumsDao: AlbumsDao) : AlbumDetailsRepository {
    override suspend fun getAlbumDetails(mbid: String, online: Boolean): Flow<AlbumInfo?> {
        return flow {
            if (online) {
                emit(albumService.getAlbumInfo(mbid).album.asDomain())
            } else {
                val albumEntity = albumsDao.findAlbumById(mbid)
                emit(AlbumInfo("", "", albumEntity.artist, emptyList(), albumEntity.imageUrl, null, null, albumEntity.album, null, albumEntity.albumPhoto))
            }
        }
    }
}