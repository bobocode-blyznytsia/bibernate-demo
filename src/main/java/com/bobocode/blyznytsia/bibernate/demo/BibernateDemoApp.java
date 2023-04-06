package com.bobocode.blyznytsia.bibernate.demo;

import com.bobocode.blyznytsia.bibernate.bootstrap.DefaultSessionFactoryBuilder;
import com.bobocode.blyznytsia.bibernate.bootstrap.SessionFactoryBuilder;
import com.bobocode.blyznytsia.bibernate.demo.model.Person;
import com.bobocode.blyznytsia.bibernate.session.Session;
import com.bobocode.blyznytsia.bibernate.session.SessionFactory;
import com.bobocode.blyznytsia.bibernate.transaction.Transaction;

public class BibernateDemoApp {

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        SessionFactoryBuilder sessionFactoryBuilder = new DefaultSessionFactoryBuilder("postgres");
        sessionFactory = sessionFactoryBuilder.createSessionFactory();
        Person person = findPerson(88L);
        System.out.println(person);
    }

    public static void createPerson() {
        //        TODO SessionFactory, Session
//        Person person = new Person();
//        person.setFirstName("John");
//        person.setLastName("Doe");
//        person.setTeam("Blyznytisa");
//        person.setEmail("john.doe@mail.com");
    }

    private static Person findPerson(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try {
            Person person = session.find(Person.class, id);
            transaction.commit();
            return person;
        } catch (Exception ex) {
            transaction.rollback();
            throw new RuntimeException("Unable to execute action in transaction", ex);
        } finally {
            session.close();
        }
    }

}
