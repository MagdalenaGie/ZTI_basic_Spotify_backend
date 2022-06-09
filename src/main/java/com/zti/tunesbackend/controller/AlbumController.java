package com.zti.tunesbackend.controller;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zti.tunesbackend.entity.AlbumEntity;
import com.zti.tunesbackend.entity.PlaylistEntity;
import com.zti.tunesbackend.entity.UserEntity;
import com.zti.tunesbackend.service.AlbumService;
import com.zti.tunesbackend.service.PlaylistService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/album")
public class AlbumController {

    private final AlbumService albumService;
    private final PlaylistService playlistService;

    public AlbumController(AlbumService albumService, PlaylistService playlistService) {
        this.albumService = albumService;
        this.playlistService = playlistService;
    }

    @GetMapping
    public List<AlbumEntity> findAllAlbums() {
        return albumService.findAllAlbums();
    }

    @GetMapping("/{id}")
    public Optional<AlbumEntity> findAlbumById(@PathVariable("id") Long id) {
        return albumService.findById(id);
    }

    @PostMapping
    public AlbumEntity saveAlbum(@RequestBody AlbumEntity albumEntity) {
        return albumService.saveAlbum(albumEntity);
    }

    @PutMapping
    public AlbumEntity updateAlbum(@RequestBody AlbumEntity albumEntity) {
        return albumService.updateAlbum(albumEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteAlbum(@PathVariable("id") Long id) {
        albumService.deleteAlbum(id);
    }
}
