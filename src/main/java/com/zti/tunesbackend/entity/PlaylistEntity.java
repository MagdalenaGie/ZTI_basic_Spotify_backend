package com.zti.tunesbackend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "playlist")
public class PlaylistEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playlist_id", unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}  )
    @JoinColumn(name="user_fk", nullable=false)
    private UserEntity owner;

    @ManyToMany(mappedBy = "playlists")
    Set<AlbumEntity> albums = new HashSet<>();

    public PlaylistEntity(){

    }

    public PlaylistEntity(String playlistName, UserEntity owner){
        this.name = playlistName;
        this.owner = owner;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String playlistName){
        this.name = playlistName;
    }

    public UserEntity getOwner(){ return owner; }

    public void setOwner(UserEntity owner){ this.owner = owner; }

    public Set<AlbumEntity> getAlbums(){
        return albums;
    }

    public void setAlbums(Set<AlbumEntity> albumsInPlaylist){
        this.albums = albumsInPlaylist;
    }

    public void addAlbumToPlaylist(AlbumEntity album){
        this.albums.add(album);
        album.getPlaylists().add(this);
    }

    public void removeAlbumToPlaylist(AlbumEntity album){
        this.albums.remove(album);
        album.getPlaylists().remove(this);
    }
}

