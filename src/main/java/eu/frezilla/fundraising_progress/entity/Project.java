package eu.frezilla.fundraising_progress.entity;

import eu.frezilla.fundraising_progress.utils.ComparatorUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.ObjectUtils;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "project")
public class Project implements Comparable<Project>, Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "current_value", nullable = false)
    private Double currentValue;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "goal_value", nullable = false)
    private Double goalValue;

    @Column(name = "name", nullable = false)
    private String name;
    
    @Lob
    @Column(name = "picture", columnDefinition="BLOB")
    private byte[] picture;
    
    @Override
    public int compareTo(Project project) {
        if (project == null) return 1;
        
        if (this.getId() == null && project.getId() == null) {
            return ComparatorUtils.compareProcess(
                    ObjectUtils.compare(getName(), project.getName()),
                    ObjectUtils.compare(getDescription(), project.getDescription()),
                    ObjectUtils.compare(getGoalValue(), project.getGoalValue()),
                    ObjectUtils.compare(getCurrentValue(), project.getCurrentValue())
            );
        } else {
            return ObjectUtils.compare(this.getId(), project.getId());
        }
    }

}
