package com.epam.note.dao;

import com.epam.note.model.Mark;
import com.epam.note.persistence.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MarkDaoImpl implements dao<Mark> {

    @Autowired
    MarkRepository markRepository;

    @Override
    public void create(Mark mark) {
        markRepository.save(mark);
    }

    @Override
    public void update(Mark mark) {

    }

    @Override
    public void delete(Mark mark) {
        markRepository.deleteByTitle(mark.getTitle());
    }

    @Override
    public List<Mark> getAll() {
        return null;
    }

    @Override
    public Mark getById(long id) {

        return markRepository.getById(id);
    }
}
