package com.zti.tunesbackend.service;
import com.zti.tunesbackend.entity.PlaylistEntity;

import java.util.List;
import java.util.Optional;


public interface PlaylistService {
    List<PlaylistEntity> findAllPlaylists();
    Optional<PlaylistEntity> findById(Long id);
    PlaylistEntity savePlaylist(PlaylistEntity playlistEntity);
    PlaylistEntity updatePlaylist(PlaylistEntity playlistEntity);
    void deletePlaylist(Long id);
}