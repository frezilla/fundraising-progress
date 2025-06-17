package eu.frezilla.fundraising_progress.entity;

import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class Play {
    
    @OneToOne
    private Project currentProject;
    
}
