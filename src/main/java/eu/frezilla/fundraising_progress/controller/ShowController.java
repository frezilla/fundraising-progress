package eu.frezilla.fundraising_progress.controller;

import eu.frezilla.fundraising_progress.entity.Show;
import eu.frezilla.fundraising_progress.repository.ShowRepository;
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

@RequestMapping("api/show")
@RequiredArgsConstructor
@RestController
public class ShowController {
    
    private final ShowRepository showRepository;
    
    @PostMapping
    public Show create(@RequestBody Show show) {
        return showRepository.save(show);
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
    
    @PutMapping("{id}")
    public Show update(@PathVariable("id") Long id, @RequestBody Show show) {
        var loaded = showRepository.findById(id).orElseThrow();
        loaded.setDescription(show.getDescription());
        loaded.setTitle(show.getTitle());
        loaded.setProjects(show.getProjects());
        return showRepository.save(loaded);
    }
}
