package eu.frezilla.fundraising_progress.repository;

import eu.frezilla.fundraising_progress.entity.ShowProjectLink;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ShowProjectLinkRepository extends JpaRepository<ShowProjectLink, ShowProjectLink.Id> {

    List<ShowProjectLink> findByProjectId(Long id);
    
    @Modifying
    @Query(value = "delete from ShowProjectLink s where s.id.showId = ?1")
    @Transactional
    void removeShowProjectLinkByIdShowId(Long id);
    
}
