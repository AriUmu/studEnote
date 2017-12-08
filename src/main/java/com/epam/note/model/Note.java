package com.epam.note.model;

import java.sql.Timestamp;

public class Note {
    private int id;
    private int idUser;
    private String title;
    private String noteBody;
    private Timestamp date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNoteBody() {
        return noteBody;
    }

    public void setNoteBody(String noteBody) {
        this.noteBody = noteBody;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        if (id != note.id) return false;
        if (idUser != note.idUser) return false;
        if (title != null ? !title.equals(note.title) : note.title != null) return false;
        if (noteBody != null ? !noteBody.equals(note.noteBody) : note.noteBody != null) return false;
        if (date != null ? !date.equals(note.date) : note.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idUser;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (noteBody != null ? noteBody.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
