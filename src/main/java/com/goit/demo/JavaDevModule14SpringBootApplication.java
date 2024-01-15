package com.goit.demo;

import com.goit.demo.notes.Note;
import com.goit.demo.notes.NoteService;

public class JavaDevModule14SpringBootApplication {

	public static void main(String[] args) {
		NoteService noteService = new NoteService();
		Note note = new Note();
		note.setContent("Hello");
		note.setTitle("World");
		note = noteService.add(note);
		Note note1 = new Note();
		note1.setContent("World");
		note1.setTitle("Hello");
		note1 = noteService.add(note1);
		System.out.println(noteService.listAll());
		noteService.deleteById(note.getId());
		System.out.println(noteService.listAll());
		note1.setTitle("Abracadabra");
		noteService.update(note1);
		System.out.println(noteService.getById(note1.getId()));
	}
}
