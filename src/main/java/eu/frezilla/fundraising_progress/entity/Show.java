package eu.frezilla.fundraising_progress.entity;

import eu.frezilla.fundraising_progress.utils.ComparatorUtils;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.ObjectUtils;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "show")
public class Show implements Comparable<Show>, Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "name", nullable = false)
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "show_id", referencedColumnName = "id")
    @OrderBy("rankid")
    private Set<ShowProjectLink> showProjectLinks = new TreeSet<>();
    
    @Transient
    private Long[] selectedProjects;
    
    @Override
    public int compareTo(Show show) {
        if (show == null) return 1;
        
        if (this.getId() == null && show.getId() == null) {
            return ComparatorUtils.compareProcess(
                    ObjectUtils.compare(getName(), show.getName()),
                    ObjectUtils.compare(getDescription(), show.getDescription())
            );
        } else {
            return ObjectUtils.compare(this.getId(), getId());
        }
    }
}