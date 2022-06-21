package com.zti.tunesbackend.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "album")
public class AlbumEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id", unique = true)
    private Long id;

    @Column(name = "collection_id")
    private Long collectionId;

    @Column(name = "playlist_fk")
    private Long playlistId;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;
    public AlbumEntity(){

    }

    public AlbumEntity(Long collectionId, Long playlistId, String title, String author){
        this.collectionId = collectionId;
        this.playlistId = playlistId;
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

    public Long getPlaylistId(){
        return playlistId;
    }

    public void setPlaylistId(Long playlistId){
        this.playlistId = playlistId;
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
}
