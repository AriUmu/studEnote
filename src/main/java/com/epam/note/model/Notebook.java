package com.epam.note.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "notebook")
public class Notebook {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "title")
    private String title;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notebook notebook = (Notebook) o;
        return title != null ? title.equals(notebook.title) : notebook.title == null;
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;

    }
}
