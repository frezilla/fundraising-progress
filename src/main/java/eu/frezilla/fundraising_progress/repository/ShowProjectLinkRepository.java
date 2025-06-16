package eu.frezilla.fundraising_progress.repository;

import eu.frezilla.fundraising_progress.entity.ShowProjectLink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowProjectLinkRepository extends JpaRepository<ShowProjectLink, ShowProjectLink.Id> {
    
    void deleteByIdShowId(Long id);
    
}
