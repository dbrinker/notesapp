package org.dbrinker.notes.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;

/**
 * Model class representing a single note.  For the time being, it is used for
 * both the persistence layer and the REST API model.  In the long run, it
 * would be preferable to have each as distinct classes (to reduce attacks
 * with bogus field values)
 */
@Data
@Table(name="notes")
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    // TODO: Initially Integer for simplicity.  Eventually change to UUID
    private Integer id;

    private String subject;
    private String text;
    private Instant lastUpdate;
    private Integer userId;
}
