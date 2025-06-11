package eu.frezilla.fundraising_progress.entity;

import jakarta.persistence.CascadeType;
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
public class Show implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String description;

    @OneToMany(mappedBy = "id.show", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<ShowProject> projects = new TreeSet();
    
    private String title;

}
