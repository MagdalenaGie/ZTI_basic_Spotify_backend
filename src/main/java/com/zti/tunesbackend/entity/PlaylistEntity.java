package com.zti.tunesbackend.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "playlist")
public class PlaylistEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playlist_id", unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="user_fk")
    private Long owner_id;

    public PlaylistEntity(){

    }

    public PlaylistEntity(String name, Long owner_id){
        this.name = name;
        this.owner_id = owner_id;
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

    public Long getOwner(){ return owner_id; }

    public void setOwner(Long owner_id){ this.owner_id = owner_id; }
}

