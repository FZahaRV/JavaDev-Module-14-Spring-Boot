package com.goit.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/list")
    public String getNoteList(Model model) {
        List<Note> notes = noteService.listAll();
        model.addAttribute("notes", notes);
        return "note/list";
    }

    @GetMapping("/create")
    public String getCreateNoteForm(Model model) {
        model.addAttribute("note", new Note());
        return "note/create";
    }

    @PostMapping("/create")
    public String createNote(@ModelAttribute("note") Note newNote) {
        noteService.add(newNote);
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public String getEditNoteForm(@RequestParam("id") long id, Model model) {
        Note noteToEdit = noteService.getById(id);
        model.addAttribute("note", noteToEdit);
        return "note/edit";
    }

    @PostMapping("/edit")
    public String editNote(@ModelAttribute("note") Note updateNote) {
        noteService.update(updateNote);
        return "redirect:/note/list";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam("id") long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }
}
