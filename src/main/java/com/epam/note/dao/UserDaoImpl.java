package com.epam.note.dao;

import com.epam.note.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository("dao")
public class UserDaoImpl implements dao<User> {

    @Autowired
    private SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session session(){
        return sessionFactory.getCurrentSession();
    }

    public User getById(int id){
     return (User) session().createQuery("select u.name from User u where u.id= :id").setParameter("id", id).uniqueResult();
    }
    public void create(User item) {

    }

    public void update(User item) {

    }

    public void delete(User item) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
