package com.epam.note;

import com.epam.note.config.AppConfig;
import com.epam.note.model.Mark;
import com.epam.note.persistence.MarkRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)

public class MarkRepoTest {

    @Autowired
    MarkRepository markRepository;

    @Test
    public void getMarkByIdTest(){
        Mark mark  = new Mark();
        mark.setId(1);
        mark.setTitle("Zametochka");

        markRepository.save(mark);
        Mark testMark = markRepository.getMarkById(1);
        assertThat(testMark, is(mark));
    }
    @Test
    public void getMarkByTitleTest(){
        Mark mark  = new Mark();
        mark.setId(1);
        mark.setTitle("Zametochka");

        markRepository.save(mark);
        Mark testMark = markRepository.getMarkByTitle("Zametochka");

        assertThat(testMark, is(mark));
    }
    @Transactional
    @Test
    public void  deleteMarkById(){

        Mark mark  = new Mark();
        mark.setId(1);
        mark.setTitle("Zametochka");
        markRepository.save(mark);
        Mark testMark = markRepository.getMarkById(1);
        assertThat(testMark, is(mark));

        markRepository.deleteMarkById(mark.getId());
        testMark = markRepository.getMarkById(1);
        assertThat(testMark,is(nullValue()));
    }

    @Transactional
    @Test
    public void  deleteMarkByTitle(){

        Mark mark  = new Mark();
        mark.setId(1);
        mark.setTitle("Zametochka");
        markRepository.save(mark);
        Mark testMark = markRepository.getMarkById(1);
        assertThat(testMark, is(mark));
        markRepository.deleteMarkByTitle("Zametochka");
        testMark = markRepository.getMarkById(1);
        assertThat(testMark, is(nullValue()));


    }
//    @Transactional
//    @Test
//    public void  deleteMarkByTitle(){
//
//        Mark mark  = new Mark();
//        mark.setId(1);
//        mark.setTitle("Zametochka");
//        markRepository.save(mark);
//        Mark testMark = markRepository.getMarkById(1);
//        assertThat(testMark, is(mark));
//
//        markRepository.deleteMarkByTitle("Zametochka");
//        testMark = markRepository.getMarkByTitle("Zametochka");
//        assertThat(testMark,is(nullValue()));
//    }
}
