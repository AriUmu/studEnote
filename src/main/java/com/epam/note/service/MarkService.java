package com.epam.note.service;

import com.epam.note.model.Mark;
import com.epam.note.model.Note;

public interface MarkService {

    void addMark(Mark mark, Note note);

    void deleteMark(Mark mark);

}
