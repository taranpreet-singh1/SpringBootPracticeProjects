package com.spring.Notepad;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Note {

    public Note(){

    }
    @Id
    @GeneratedValue
private int id;
private String username;
private String heading;

@Size(min=10, message="Enter atleast 10 characters")
private String description;

    public Note(int id, String username, String heading, String description) {
        this.id = id;
        this.username = username;
        this.heading = heading;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", heading='" + heading + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
