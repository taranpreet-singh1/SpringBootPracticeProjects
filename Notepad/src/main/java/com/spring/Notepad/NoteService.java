package com.spring.Notepad;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class NoteService {
    private static List<Note> notes = new ArrayList<>();

    private static int todosCount = 0;

    static{
        notes.add(new Note(1,"singht", "First Sample Note", "This is note's description"));
        notes.add(new Note(2,"singht","Second Sample Note", "This is Second note's description"));
        notes.add(new Note(3,"singht","Third Sample Note", "This is third note's description"));
    }

    public List<Note> findByUsername(String username){
        return notes;
    }

    public void addNote(String username, String heading, String description){
        Note note = new Note(++todosCount,username, heading,description);
        notes.add(note);
    }

    public void deleteById(int id){
        Predicate<? super Note> predicate = note -> note.getId() == id;
        notes.removeIf(predicate);
    }

    public Note findById(int id){
        Predicate<? super Note> predicate = note -> note.getId() == id;
        Note note = notes.stream().filter(predicate).findFirst().get();
        return note;
    }

    public void updateNote(@Valid Note note){
        deleteById(note.getId());
        notes.add(note);
    }

}
