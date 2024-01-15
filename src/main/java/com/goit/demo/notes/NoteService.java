package com.goit.demo.notes;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
@Service
public class NoteService {
    private Map<Long, Note> notes = new LinkedHashMap<>();

    public Map<Long ,Note> listAll() {
        return notes;
    }

    public Note add(Note note) {
        note.setId();
        notes.put(note.getId(), note);
        return note;
    }

    public void deleteById(Long id) {
        if (notes.containsKey(id)) {
            notes.remove(id);
        } else {
            System.out.println("Note with given ID does not exist");
        }
    }
    public void update(Note note) {
        if(notes.containsKey(note.getId())) {
            notes.replace(note.getId(), notes.get(note.getId()), note);
        } else {
            System.out.println("Note with given ID does not exist");
        }
    }
    public Note getById(Long id) {
        if (notes.containsKey(id)) {
            return notes.get(id);
        } else {
            System.out.println("Note with given ID does not exist");
            return null;
        }
    }
}