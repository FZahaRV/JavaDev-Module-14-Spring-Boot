package com.goit.notes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final int MAX_CONTENT_LENGTH = 200;
    private final int MAX_TITLE_LENGTH = 100;

    private final NoteRepository repository;
    public List<Note> listAll() {
        return new ArrayList<>(repository.findAll());
    }

    public Note create(Note note) {
        if(note == null || note.getTitle().isEmpty() ||
                note.getContent().isEmpty() ||
                note.getTitle().length() > MAX_TITLE_LENGTH ||
                note.getContent().length() > MAX_CONTENT_LENGTH) {
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

    public void saveOrUpdate(Note note) {
        long id = note.getId();
        if (!repository.existsById(id) || note.getTitle().isEmpty() ||
                note.getContent().isEmpty() ||
                note.getTitle().length() > MAX_TITLE_LENGTH ||
                note.getContent().length() > MAX_CONTENT_LENGTH) {
            throw new RuntimeException("Note with id " + id + " not found");
        } else {
            repository.save(note);
        }
    }

    public Optional<Note> getById(long id) {
        return repository.findById(id);
    }
}