package eu.frezilla.fundraising_progress.repository;

import eu.frezilla.fundraising_progress.entity.Play;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PlayRepository extends JpaRepository<Play, Long> {
    
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO play (id, project_id) VALUES (0, ?1)")
    @Transactional
    void createProjectId(Long projectId);
    
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE play SET project_id= ?1 WHERE id = 0")
    @Transactional
    void updateProjectId(Long projectId);
    
}
