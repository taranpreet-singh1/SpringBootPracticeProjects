package com.spring.Notepad;

import java.util.List;

public class NoteService {
    private static List<Note> notes;

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

}
