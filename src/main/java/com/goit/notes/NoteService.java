package com.goit.notes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository repository;
    public List<Note> listAll() {
        return new ArrayList<>(repository.findAll());
    }

    public Note create(Note note) {
        if(note == null) {
            throw new RuntimeException("Note is null");
        } else {
            return repository.save(note);
        }
    }

    public void deleteById(long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Note with id " + id + " not found");
        } else {
            repository.deleteById(id);
        }
    }

    public void update(Note note) {
        long id = note.getId();
        if (!repository.existsById(id)) {
            throw new RuntimeException("Note with id " + id + " not found");
        } else {
            repository.save(note);
        }
    }

    public Optional<Note> getById(long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Note with id " + id + " not found");
        } else {
            return repository.findById(id);
        }
    }
}