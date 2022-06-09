package com.zti.tunesbackend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "album")
public class AlbumEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id", unique = true)
    private Long id;

    @Column(name = "collection_id", unique = true)
    private Long collectionId;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @ManyToMany(
            cascade = {CascadeType.MERGE, CascadeType.PERSIST}
    )
    @JoinTable(
            name = "playlist_album",
            joinColumns = @JoinColumn(name = "album_fk"),
            inverseJoinColumns = @JoinColumn(name = "playlist_fk"
            ))
    Set<PlaylistEntity> playlists = new HashSet<>();

    public AlbumEntity(){

    }

    public AlbumEntity(Long collectionId, String title, String author){
        this.collectionId = collectionId;
        this.title = title;
        this.author = author;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCollectionId(){
        return collectionId;
    }

    public void setCollectionId(Long collectionId){
        this.collectionId = collectionId;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public Set<PlaylistEntity> getPlaylists(){
        return playlists;
    }

    public void setPlaylists(Set<PlaylistEntity> playlists){
        this.playlists = playlists;
    }

    public void addPlaylist(PlaylistEntity playlist){
        this.playlists.add(playlist);
        playlist.getAlbums().add(this);
    }

    public void removePlaylist(PlaylistEntity playlist){
        this.playlists.remove(playlist);
        playlist.getAlbums().remove(this);
    }
}
