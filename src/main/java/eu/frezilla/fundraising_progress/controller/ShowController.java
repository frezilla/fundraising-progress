package eu.frezilla.fundraising_progress.controller;

import eu.frezilla.fundraising_progress.entity.Project;
import eu.frezilla.fundraising_progress.entity.Show;
import eu.frezilla.fundraising_progress.entity.ShowProjectLink;
import eu.frezilla.fundraising_progress.entity.ShowProjectLink.Id;
import eu.frezilla.fundraising_progress.repository.ProjectRepository;
import eu.frezilla.fundraising_progress.repository.ShowRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import eu.frezilla.fundraising_progress.repository.ShowProjectLinkRepository;

@RequestMapping("api/show")
@RequiredArgsConstructor
@RestController
public class ShowController {
    
    private final ProjectRepository projectRepository;
    private final ShowProjectLinkRepository showProjectRepository;
    private final ShowRepository showRepository;
    
    @PostMapping
    public Show create(@RequestBody Show show) {
        int rankId = 0;
        
        show = showRepository.save(show);
        
        for (Long projectId : show.getSelectedProjects()) {
            ShowProjectLink showProject = new ShowProjectLink();

            Project project = projectRepository.findById(projectId).orElseThrow();
            showProject.setProject(project);
            
            ShowProjectLink.Id id = new Id();
            id.setRankId(rankId);
            //id.setShow(show);
            showProject.setId(id);
            
//            show.getProjects().add(showProject);
            
            rankId++;
        }
        
        return show;
    }
    
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        showRepository.deleteById(id);
    }
    
    @GetMapping
    public Page<Show> findAll(Pageable pageable) {
        return showRepository.findAll(pageable);
    }
    
    @GetMapping("{id}")
    public Optional<Show> findById(@PathVariable("id") Long id) {
        return showRepository.findById(id);
    }
    
    @GetMapping("/getavalaibleprojects")
    public List<Project> getAvalaibleProjects(@RequestParam(defaultValue = "0") Long id) {
        List<Project> projects = projectRepository.findAll();
        if (Objects.equals(id, (long) 0)) {
            return projects;
        } else {
//            var loaded = findById(id);
//            if (loaded.isEmpty()) return projects;
//            
//            Set<ShowProjectLink> showProjects = loaded.get().ge();
//            List<Project> returnProjects = new ArrayList<>();
//            for (Project project : projects) {
//                if (showProjects.stream().filter(sp -> Objects.equals(sp.getProject().getId(), project.getId())).count() == 0) {
//                    returnProjects.add(project);
//                }
//            }
//            return returnProjects;
            return null;
        }
    }
    
    @PutMapping("{id}")
    public Show update(@PathVariable("id") Long id, @RequestBody Show show) {
        var loaded = showRepository.findById(id).orElseThrow();
        loaded.setDescription(show.getDescription());
       // loaded.setTitle(show.getTitle());
        loaded.setShowProjectLinks(show.getShowProjectLinks());
        return showRepository.save(loaded);
    }
}
