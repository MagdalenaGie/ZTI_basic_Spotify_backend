package com.zti.tunesbackend.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zti.tunesbackend.entity.AlbumEntity;
import com.zti.tunesbackend.service.AlbumService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/album")
@CrossOrigin(origins = "*")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) { this.albumService = albumService; }

    @GetMapping
    public List<AlbumEntity> findAllAlbums() {
        return albumService.findAllAlbums();
    }

    @GetMapping("/{id}")
    public Optional<AlbumEntity> findAlbumById(@PathVariable("id") Long id) {
        return albumService.findById(id);
    }

    @GetMapping("/playlist/{id}")
    public List<AlbumEntity> findAlbumsFromPlaylist(@PathVariable("id") Long id) {
        List<AlbumEntity> all = albumService.findAllAlbums();
        List<AlbumEntity> albumsInPlaylist = new ArrayList<>() ;
        all.forEach(album -> {
            if (album.getPlaylistId() == id){
                albumsInPlaylist.add(album);
            }
        });

        return albumsInPlaylist;
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
