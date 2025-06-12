package eu.frezilla.fundraising_progress.controller;

import eu.frezilla.fundraising_progress.entity.ShowProject;
import eu.frezilla.fundraising_progress.repository.ShowProjectRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ShowProjectController {
    
    private final ShowProjectRepository showProjectRepository;
    
    @RequestMapping("/api/showproject/findbyshowid/{id}")
    public List<ShowProject> findByShowId(@PathVariable("id") Long id) {
        return showProjectRepository.findByIdShowId(id);
    }
    
}
