package com.github.danrog303.notepad.domain.note;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @GetMapping
    public String showNotepadHomepage(Model model) {
        model.addAttribute("note", new Note());
        model.addAttribute("existingNotes", noteService.getAllNotes());
        return "note";
    }

    @PostMapping
    public String handleNoteCreationForm(@Valid @ModelAttribute Note note, BindingResult validationResult, Model model) {
        if (validationResult.hasErrors()) {
            model.addAttribute("note", validationResult.getTarget());
            model.addAttribute("existingNotes", noteService.getAllNotes());
            return "note";
        } else {
            noteService.createNote(note);
            return "redirect:/note";
        }
    }
}
