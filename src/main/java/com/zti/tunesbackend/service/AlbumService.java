package com.zti.tunesbackend.service;
import com.zti.tunesbackend.entity.AlbumEntity;

import java.util.List;
import java.util.Optional;


public interface AlbumService {
    List<AlbumEntity> findAllAlbums();
    Optional<AlbumEntity> findById(Long id);
    AlbumEntity saveAlbum(AlbumEntity albumEntity);
    AlbumEntity updateAlbum(AlbumEntity albumEntity);
    void deleteAlbum(Long id);
}
