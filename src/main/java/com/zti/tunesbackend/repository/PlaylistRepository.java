package com.zti.tunesbackend.repository;
import com.zti.tunesbackend.entity.PlaylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<PlaylistEntity, Long> {
}
