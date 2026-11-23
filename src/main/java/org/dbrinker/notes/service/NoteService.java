package org.dbrinker.notes.service;

import org.dbrinker.notes.model.Note;

import java.util.List;

/**
 * Defines the service used for business logic and persistence processing of
 * notes.
 */
public interface NoteService {
    Note create(Note toCreate);

    List<Note> getMany();

    Note getOne(Integer id);

    Note update(Note toUpdate);

    void delete(Integer idToDelete);
}
