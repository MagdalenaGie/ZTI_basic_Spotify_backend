package com.zti.tunesbackend.service.impl;
import com.zti.tunesbackend.entity.AlbumEntity;
import com.zti.tunesbackend.repository.AlbumRepository;
import com.zti.tunesbackend.service.AlbumService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<AlbumEntity> findAllAlbums() {
        return albumRepository.findAll();
    }

    @Override
    public Optional<AlbumEntity> findById(Long id) {
        return albumRepository.findById(id);
    }

    @Override
    public AlbumEntity saveAlbum(AlbumEntity albumEntity) {
        return albumRepository.save(albumEntity);
    }

    @Override
    public AlbumEntity updateAlbum(AlbumEntity albumEntity) {
        return albumRepository.save(albumEntity);
    }

    @Override
    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }
}

