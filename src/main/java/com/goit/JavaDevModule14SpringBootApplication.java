package com.goit;

import com.goit.notes.Note;
import com.goit.notes.NoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JavaDevModule14SpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JavaDevModule14SpringBootApplication.class, args);
		NoteService noteService = context.getBean(NoteService.class);
		testNoteService(noteService);
	}

	private static void testNoteService(NoteService noteService) {
		Note note = new Note();
		note.setTitle("World");
		note.setContent("Hello");
		noteService.add(note);
		System.out.println("New note: " + note);
		System.out.println("All notes: " + noteService.listAll());
		Note note1 = noteService.getById(note.getId());
		System.out.println("Note by id " + note.getId() + ": " + note1);
		note.setTitle("Updated Title");
		noteService.update(note);
		System.out.println("Updated note: " + note);
		System.out.println("All notes after update: " + noteService.listAll());
		noteService.deleteById(note.getId());
		System.out.println("Deleted note with id " + note.getId());
		System.out.println("All notes after deletion: " + noteService.listAll());
	}
}