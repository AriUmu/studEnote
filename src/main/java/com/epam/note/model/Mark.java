package com.epam.note.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mark")
public class Mark {

    @Id
    @GeneratedValue
    private long id;

    private String title;

    public Mark() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mark mark = (Mark) o;

        return title != null ? title.equals(mark.title) : mark.title == null;
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }



//    private Set<Note> noteSet = new HashSet<>();

//    @ManyToMany
//    @JoinTable(name = "mark_note",
//            joinColumns = {@JoinColumn(name = "id_metka")},
//            inverseJoinColumns = {@JoinColumn(name = "id_note")})
//
//    public Set<Note> getNoteSet() {
//        return noteSet;
//    }
//
//    public void setNoteSet(Set<Note> noteSet) {
//        this.noteSet = noteSet;
//    }
}

