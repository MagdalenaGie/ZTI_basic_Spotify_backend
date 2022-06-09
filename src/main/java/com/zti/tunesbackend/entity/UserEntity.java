package com.zti.tunesbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account_user")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true)
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "playlist_id")
//    private Set<PlaylistEntity> playlists;
    @OneToMany(
        mappedBy = "owner",
        cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
        orphanRemoval = true
    )
    @JsonIgnore
    private List<PlaylistEntity> playlists = new ArrayList<>();;


    public UserEntity() {
    }

    public UserEntity(String name, String username, String password, String gender) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<PlaylistEntity> getPlaylists(){ return playlists; }

    public void setPlaylists(List<PlaylistEntity> playlists){ this.playlists = playlists; }

    public void addPlaylist(PlaylistEntity playlist){
        playlists.add(playlist);
        playlist.setOwner(this);
    }

    public void removePlaylist(PlaylistEntity playlist){
        playlists.remove(playlist);
        playlist.setOwner(null);
    }
}