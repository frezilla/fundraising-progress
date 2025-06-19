package eu.frezilla.fundraising_progress.controller;

import eu.frezilla.fundraising_progress.entity.Play;
import eu.frezilla.fundraising_progress.repository.PlayRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/play")
@RequiredArgsConstructor
@RestController
public class PlayController {
    
    private final PlayRepository playRepository;
    
    @GetMapping("{id}")
    public Optional<Play> findById(@PathVariable("id") Long id) {
        return playRepository.findById(id);
    }
    
}