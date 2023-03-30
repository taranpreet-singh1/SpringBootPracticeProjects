package com.spring.Notepad;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Integer> {

    public List<Note> findByUsername(String username);

}
