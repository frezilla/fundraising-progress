package eu.frezilla.fundraising_progress.controller;

import eu.frezilla.fundraising_progress.entity.Play;
import eu.frezilla.fundraising_progress.entity.Project;
import eu.frezilla.fundraising_progress.repository.PlayRepository;
import eu.frezilla.fundraising_progress.repository.ProjectRepository;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/play")
@RequiredArgsConstructor
@RestController
public class PlayController {
    
    private static final Long ID = 0L;
    
    private final PlayRepository playRepository;
    private final ProjectRepository projectRepository;
    
    @GetMapping()
    public Play find() {
        return playRepository.findById(ID).orElse(new Play(ID, null));
    }
    
    @PutMapping("{id}")
    public void save(@NonNull @PathVariable("id") Long projectId) {
        projectRepository.findById(projectId).orElseThrow();
        
        if (playRepository.findById(ID).isPresent()) {
            playRepository.updateProjectId(projectId);
        } else {
            playRepository.createProjectId(projectId);
        }
    }
    
}