package com.zti.tunesbackend.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zti.tunesbackend.entity.PlaylistEntity;
import com.zti.tunesbackend.service.PlaylistService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/playlist")
@CrossOrigin(origins = "*")
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping
    public List<PlaylistEntity> findAllPlaylists() {
        return playlistService.findAllPlaylists();
    }

    @GetMapping("/{id}")
    public Optional<PlaylistEntity> findPlaylistById(@PathVariable("id") Long id) {
        return playlistService.findById(id);
    }

    @GetMapping("/owner/{id}")
    public List<PlaylistEntity> findPlaylistByOwnerId(@PathVariable("id") Long id) {
        List<PlaylistEntity> all = playlistService.findAllPlaylists();
        List<PlaylistEntity> ownersPlaylists = new ArrayList<>() ;
        all.forEach(playlist -> {
            if (playlist.getOwner() == id){
                ownersPlaylists.add(playlist);
            }
        });

        return ownersPlaylists;
    }

    @PostMapping
    public PlaylistEntity savePlaylist(@RequestBody PlaylistEntity playlistEntity) {
        return playlistService.savePlaylist(playlistEntity);
    }

    @PutMapping
    public PlaylistEntity updatePlaylist(@RequestBody PlaylistEntity playlistEntity) {
        return playlistService.updatePlaylist(playlistEntity);
    }

    @DeleteMapping("/{id}")
    public void deletePlaylist(@PathVariable("id") Long id) {
        playlistService.deletePlaylist(id);
    }
}
