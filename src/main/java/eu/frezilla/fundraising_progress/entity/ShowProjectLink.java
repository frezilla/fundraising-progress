package eu.frezilla.fundraising_progress.entity;

import eu.frezilla.fundraising_progress.utils.ComparatorUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.ObjectUtils;

@Data
@Entity
@Table(name = "show_project_link")
public class ShowProjectLink implements Comparable<ShowProjectLink>, Serializable {

    @EmbeddedId
    private Id id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;

    @Override
    public int compareTo(ShowProjectLink showProject) {
        if (showProject == null) return 1;
        
        return ComparatorUtils.compareProcess(
                ObjectUtils.compare(getId(), showProject.getId()),
                ObjectUtils.compare(getProject(), showProject.getProject())
        );
    }

    @Data
    @Embeddable
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    public static class Id implements Comparable<Id>, Serializable {

        @Column(name = "rankid", nullable = false)
        @EqualsAndHashCode.Include
        private Integer rankId;

        @Column(name = "show_id", nullable = false)
        @EqualsAndHashCode.Include
        private Long showId;

        @Override
        public int compareTo(Id id) {
            if (id == null) return 1;

            return ComparatorUtils.compareProcess(
                    ObjectUtils.compare(getShowId(), id.getShowId()),
                    ObjectUtils.compare(getRankId(), id.getRankId())
            );
        }
    }
}
