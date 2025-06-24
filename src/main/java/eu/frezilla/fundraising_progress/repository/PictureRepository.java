package eu.frezilla.fundraising_progress.repository;

import eu.frezilla.fundraising_progress.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
    
}
