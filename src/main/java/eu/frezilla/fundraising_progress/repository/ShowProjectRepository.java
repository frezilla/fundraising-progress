package eu.frezilla.fundraising_progress.repository;

import eu.frezilla.fundraising_progress.entity.Project;
import eu.frezilla.fundraising_progress.entity.ShowProject;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowProjectRepository extends JpaRepository<ShowProject, ShowProject.Id> {
    
    List<ShowProject> findByProject(Project project);
    
    List<ShowProject> findByIdShowId(Long id);
    
}