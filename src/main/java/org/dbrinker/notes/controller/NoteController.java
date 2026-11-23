package org.dbrinker.notes.controller;

import lombok.RequiredArgsConstructor;
import org.dbrinker.notes.model.Note;
import org.dbrinker.notes.service.NoteService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.constraints.NotNull;
import java.util.List;

/**
 * REST Controller for the "/notes" API
 */
@RestController("/notes")
@RequiredArgsConstructor
@Validated
public class NoteController {
    private final NoteService noteService;

    @PostMapping
    public @ResponseBody Note create(@RequestBody @NotNull Note toCreate) {
        return noteService.create(toCreate);
    }

    /**
     * Process a standard "GET all" operation, returning all notes known by the
     * system.
     *
     * TODO: Add querying by user
     *
     * @return  The notes, or an empty list if none were found
     */
    @GetMapping
    public @ResponseBody List<Note> getAll() {
        return noteService.getMany();
    }

    /**
     * Process a standard "GET one" operation, returning the given note.
     * If the note cannot be found, a JpaObjectRetrievalFailureException will
     * be thrown.  (Not included in the javadoc to avoid unnecessary dependencies)
     *
     * @return  The note, presuming it exists
     */
    @GetMapping("{id}")
    public @ResponseBody Note getNote(@PathVariable Integer id) {
        return noteService.getOne(id);
    }

    /**
     * Updates the given note in response to a HTTP PUT.  If the note cannot
     * be found, a JpaObjectRetrievalFailureException will be thrown.  (Not
     * included in the javadoc to avoid unnecessary dependencies)
     *
     * @param toUpdate  The note in question
     *
     * @return  The updated note
     */
    @PutMapping
    public @ResponseBody Note update(@RequestBody @NotNull Note toUpdate) {
        return noteService.update(toUpdate);
    }

    /**
     * Deletes the given note permanently from persistent storage.  If the
     * note in question does not exist, this is effectively a no-op
     *
     * @param idToDelete  ID of the note in question.
     */
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer idToDelete) {
        noteService.delete(idToDelete);
    }
}
