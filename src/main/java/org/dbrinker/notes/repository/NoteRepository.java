package org.dbrinker.notes.repository;

import org.dbrinker.notes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// NOTE:  It's debatable whether this would be better as a database record or
//        an entry in a MongoDB collection, especially since the note is
//        essentially an annotated text block (i.e. the sweet spot for
//        something like Mongo).  We're just going to do the former
//        for the time being given our limited time to implement.

/**
 * Persistence repository used to query and modify Note instances
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {
    /**
     * Retrieve the collection of all notes, ordering them by most recent
     * notes first.  This was chosen as more recent notes tend to be the
     * most commonly accessed, especially as the number of notes grows
     *
     * @return  The notes, with the most recently created/updated notes first
     */
    List<Note> findByOrderByLastUpdateDesc();
}
