package com.tekydevelop.data.mapper

import com.tekydevelop.data.db.entity.AlbumEntity
import com.tekydevelop.domain.model.entity.AlbumItem

object DbEntityMapper {

    fun mapToEntity(albumEntity: AlbumEntity): AlbumItem {
        return AlbumItem(albumEntity.mbid, albumEntity.album, albumEntity.artist, albumEntity.imageUrl)
    }
}