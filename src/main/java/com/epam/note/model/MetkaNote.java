package com.epam.note.model;

import javax.persistence.Id;

public class MetkaNote {
    @Id
    private int idNote;
    private int idMetka;

    public int getIdNote() {
        return idNote;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    public int getIdMetka() {
        return idMetka;
    }

    public void setIdMetka(int idMetka) {
        this.idMetka = idMetka;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetkaNote metkaNote = (MetkaNote) o;

        if (idNote != metkaNote.idNote) return false;
        if (idMetka != metkaNote.idMetka) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idNote;
        result = 31 * result + idMetka;
        return result;
    }

//    private String id;
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
}
