package eu.frezilla.fundraising_progress.repository;

import eu.frezilla.fundraising_progress.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    
}
