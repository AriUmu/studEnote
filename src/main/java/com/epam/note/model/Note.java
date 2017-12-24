package com.epam.note.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "note")
public class Note {


    @Id
    @GeneratedValue
    private long id;

    private String title;

    private String text;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date;

    private long id_notebook;


    public Note() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setIdNotebook(long idNotebook) {
        this.id_notebook = idNotebook;
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

    public Date getDate() {
        return date;
    }

    public long getIdNotebook() {
        return id_notebook;
    }

    public String getText() {
        return text;
    }

//    public void addLabel(Mark mark) {
//        notes.add(mark);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        if (id_notebook != note.id_notebook) return false;
        if (title != null ? !title.equals(note.title) : note.title != null) return false;
        if (text != null ? !text.equals(note.text) : note.text != null) return false;
        return date != null ? date.equals(note.date) : note.date == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (int) (id_notebook ^ (id_notebook >>> 32));
        return result;
    }
}


