package org.dbrinker.notes.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.dbrinker.notes.model.Note;
import org.dbrinker.notes.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NoteRepository repository;

    @Override
    public Note create(Note toCreate) {
        return repository.save(toCreate);
    }

    @Override
    public List<Note> getMany() {
        return repository.findByOrderByLastUpdateDesc();
    }

    @Override
    public Note getOne(Integer id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Note update(Note toUpdate) {
        return repository.save(toUpdate);
    }

    @Override
    public void delete(Integer idToDelete) {
        repository.deleteById(idToDelete);

    }
}
