package eu.frezilla.fundraising_progress.repository;

import eu.frezilla.fundraising_progress.entity.Play;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayRepository extends JpaRepository<Play, Long> {
    
}
