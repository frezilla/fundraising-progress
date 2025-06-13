package eu.frezilla.fundraising_progress.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import lombok.Data;

@Data
@Entity
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double currentValue;

    private String description;

    private Double goalValue;

    private String name;
    
    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
    private Set<ShowProject> shows = new TreeSet();

}
