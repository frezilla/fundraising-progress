package eu.frezilla.fundraising_progress.controller;

import eu.frezilla.fundraising_progress.entity.Picture;
import eu.frezilla.fundraising_progress.repository.PictureRepository;
import java.io.IOException;
import java.util.Base64;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("api/picture")
@RequiredArgsConstructor
@RestController
public class PictureController {
    
    private final PictureRepository pictureRepository;
    
    @RequestMapping(value = "delete")
    public void delete(@NonNull @RequestParam("id") Long projectId) {
        Optional<Picture> opt = pictureRepository.findById(projectId);
        
        if (opt.isPresent()) {
            Picture pic = opt.get();
            pictureRepository.delete(pic);
        }
    }

    @RequestMapping(value = "upload")
    public Picture save(@RequestParam("file") MultipartFile multiPartFile, @NonNull @RequestParam("id") Long projectId) throws IOException {
        Picture picture = new Picture();
        picture.setProjectId(projectId);
        byte[] bytes = Base64.getEncoder().encode(multiPartFile.getBytes());
        picture.setPicture(bytes);
        return pictureRepository.save(picture);
    }

}