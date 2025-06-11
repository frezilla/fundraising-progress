package eu.frezilla.fundraising_progress.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
public class ShowProject implements Serializable {

    @EmbeddedId
    private Id id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Project project;

    @Data
    @Embeddable
    public static class Id implements Serializable {

        private Integer rankId;
        
        @ManyToOne
        private Show show;
        
    }

}
