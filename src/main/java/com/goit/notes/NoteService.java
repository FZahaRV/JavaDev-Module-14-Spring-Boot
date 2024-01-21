package com.goit.notes;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class NoteService {
    private final Map<Long, Note> notes = new HashMap<>();
    private final Random random = new Random();

    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    public Note add(Note note) {
        long id = generateUniqueId();
        note.setId(id);
        notes.put(id, note);
        return note;
    }

    public void deleteById(long id) {
        if (!notes.containsKey(id)) {
            throw new RuntimeException("Note with id " + id + " not found");
        }
        notes.remove(id);
    }

    public void update(Note note) {
        long id = note.getId();
        if (!notes.containsKey(id)) {
            throw new RuntimeException("Note with id " + id + " not found");
        }
        notes.put(id, note);
    }

    public Note getById(long id) {
        if (!notes.containsKey(id)) {
            throw new RuntimeException("Note with id " + id + " not found");
        }
        return notes.get(id);
    }

    private long generateUniqueId() {
        return random.nextLong();
    }
}