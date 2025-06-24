package eu.frezilla.fundraising_progress.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "picture")
public class Picture implements Serializable {
    
    @Id
    @Column(name = "project_id", nullable = false)
    private Long projectId;
    
    @Lob
    @Column(name = "picture", columnDefinition="BLOB")
    private byte[] picture;
    
}
