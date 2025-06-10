package eu.frezilla.fundraising_progress.repository;

import eu.frezilla.fundraising_progress.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    
}
