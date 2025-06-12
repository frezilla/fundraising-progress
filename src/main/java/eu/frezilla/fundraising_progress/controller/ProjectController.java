package eu.frezilla.fundraising_progress.controller;

import eu.frezilla.fundraising_progress.entity.Project;
import eu.frezilla.fundraising_progress.repository.ProjectRepository;
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
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/project")
@RequiredArgsConstructor
@RestController
public class ProjectController {
    
    private final ProjectRepository projectRepository;
    
    @PostMapping
    public Project create(@RequestBody Project project) {
        return projectRepository.save(project);
    }
    
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        projectRepository.deleteById(id);
    }
    
    @GetMapping
    public Page<Project> findAll(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }
    
    @GetMapping("{id}")
    public Optional<Project> findById(@PathVariable("id") Long id) {
        return projectRepository.findById(id);
    }
    
    @PutMapping("{id}")
    public Project update(@PathVariable("id") Long id, @RequestBody Project project) {
        var loaded = projectRepository.findById(id).orElseThrow();
        loaded.setCurrentValue(project.getCurrentValue());
        loaded.setDescription(project.getDescription());
        loaded.setGoalValue(project.getGoalValue());
        loaded.setName(project.getName());
        return projectRepository.save(loaded);
    }
        
}
