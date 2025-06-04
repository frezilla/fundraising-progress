package eu.frezilla.fundraising_progress.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
public class Project implements Serializable {
    
    @Id
    private Long id;
    
    private Double currentValue;
    
    private String description;
    
    private Double goalValue;
    
    private String name;
        
}
