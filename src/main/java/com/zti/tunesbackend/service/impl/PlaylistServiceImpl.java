package com.zti.tunesbackend.service.impl;
import com.zti.tunesbackend.entity.PlaylistEntity;
import com.zti.tunesbackend.repository.PlaylistRepository;
import com.zti.tunesbackend.service.PlaylistService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;

    public PlaylistServiceImpl(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public List<PlaylistEntity> findAllPlaylists() {
        return playlistRepository.findAll();
    }

    @Override
    public Optional<PlaylistEntity> findById(Long id) {
        return playlistRepository.findById(id);
    }

    @Override
    public PlaylistEntity savePlaylist(PlaylistEntity playlistEntity) {
        return playlistRepository.save(playlistEntity);
    }

    @Override
    public PlaylistEntity updatePlaylist(PlaylistEntity playlistEntity) {
        return playlistRepository.save(playlistEntity);
    }

    @Override
    public void deletePlaylist(Long id) {
        playlistRepository.deleteById(id);
    }
}