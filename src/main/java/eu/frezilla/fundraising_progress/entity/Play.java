package eu.frezilla.fundraising_progress.entity;

import jakarta.persistence.OneToOne;

public class Play {
    
    @OneToOne
    private Project currentProject;
    
}
