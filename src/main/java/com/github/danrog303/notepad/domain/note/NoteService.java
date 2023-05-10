package com.github.danrog303.notepad.domain.note;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public void createNote(Note note) {
        note.setId(null);
        note.setTimestamp(new Date());
        noteRepository.save(note);
    }
}
