package com.epam.note.service.Impl;

import com.epam.note.model.Mark;
import com.epam.note.model.Note;
import com.epam.note.service.MarkService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MarkServiceImpl implements MarkService {
    private List<Note> list = new ArrayList<>();

    private HashMap<Mark, List<Note>> markNoteHashMap = new HashMap<>();

    public HashMap<Mark, List<Note>> getMarkNoteHashMap() {
        return markNoteHashMap;
    }

    public void setMarkNoteHashMap(HashMap<Mark, List<Note>> markNoteHashMap) {
        this.markNoteHashMap = markNoteHashMap;
    }

    @Override
    public void addMark(Mark mark, Note note) {
        list.add(note);
        markNoteHashMap.put(mark, list);
    }

    @Override
    public void deleteMark(Mark mark) {
        markNoteHashMap.remove(mark);
    }
}
