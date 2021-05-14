package com.example.reposetory;

import com.example.model.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class PeopleRepo {

    SessionFactory factory ;

    public PeopleRepo(SessionFactory sessionFactory) {
        this.factory = sessionFactory;
    }


    public List<People> getAll(){
        Session session = this.factory.getCurrentSession();
//        List peoples = session.createQuery("from People").list();
        Query from_people = session.createQuery("from People");
        List<People> resultList = from_people.list();
        return resultList;
    }
//    @MockBean
//    private SessionFactory sessionFactory;
//    @MockBean
//    private Session session;
//    when(sessionFactory.getCurrentSession()).thenReturn(session);
//    Query q = Mockito.mock(Query.class);

//    when(session.createQuery("from People")).thenReturn(q);
//    when((q).list()).thenReturn(peopleList);
//    List list = repo.getAll();
//    assertAll("People",()-> assertNotEquals(list,null),()->assertEquals(list.size(),2));

    public People save(People people){
        factory.getCurrentSession().save(people);
        return people;
    }
    public People getById(Long id){
        Session session = factory.getCurrentSession();
        Query<People> query = session.createQuery("from People p where p.id = :id");
                query.setParameter("id",id);
        People people = query.getSingleResult();
        session.close();
        return people;
//        return factory.getCurrentSession().get(People.class,id);
    }
    public String deleteById(Long id){
//        factory.getCurrentSession().delete(getById(id));
        People people = new People();
        people.setId(id);
        factory.getCurrentSession().delete(people);
        return "success delete people id=" + id;
    }
    public void update(People people, Long id){
        people.setId(id);
        factory.getCurrentSession().update(people);
    }
    public People getByName(String name){
        return (People) factory.getCurrentSession()
                .createQuery("from People p where p.name = :name")
                .setParameter("name",name).getSingleResult();
    }
}