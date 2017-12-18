package com.epam.note.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "note")
public class Note {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_notebook")
    private Notebook notebook;

    @Id
    @GeneratedValue
    private long id;

    private String title;

    private String text;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime date;

    private long idNotebook;

    @ManyToMany
    @JoinTable(name = "note_mark",
            joinColumns = @JoinColumn(name = "id_note"),
            inverseJoinColumns = @JoinColumn(name = "id_metka")
    )
    private List<Mark> notes = new ArrayList<>();

    public Note() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setIdNotebook(long idNotebook) {
        this.idNotebook = idNotebook;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public long getIdNotebook() {
        return idNotebook;
    }

    public String getText() {
        return text;
    }

    public void addLabel(Mark mark) {
        notes.add(mark);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        if (idNotebook != note.idNotebook) return false;
        if (title != null ? !title.equals(note.title) : note.title != null) return false;
        if (text != null ? !text.equals(note.text) : note.text != null) return false;
        return date != null ? date.equals(note.date) : note.date == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (int) (idNotebook ^ (idNotebook >>> 32));
        return result;
    }
}


