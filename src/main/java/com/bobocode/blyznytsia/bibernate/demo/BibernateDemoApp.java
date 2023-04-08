package com.bobocode.blyznytsia.bibernate.demo;


import com.bobocode.blyznytsia.bibernate.bootstrap.DefaultSessionFactoryBuilder;
import com.bobocode.blyznytsia.bibernate.demo.model.Note;
import com.bobocode.blyznytsia.bibernate.demo.model.NoteStats;
import com.bobocode.blyznytsia.bibernate.demo.model.Person;
import com.bobocode.blyznytsia.bibernate.demo.repository.NoteRepository;
import com.bobocode.blyznytsia.bibernate.demo.repository.PersonRepository;
import com.bobocode.blyznytsia.bibernate.repository.BibernateReadonlyRepository;
import com.bobocode.blyznytsia.bibernate.repository.RepositoryBuilder;
import com.bobocode.blyznytsia.bibernate.session.Session;
import com.bobocode.blyznytsia.bibernate.session.SessionFactory;
import com.bobocode.blyznytsia.bibernate.transaction.Transaction;
import java.util.List;
import java.util.Optional;

public class BibernateDemoApp {

  private static SessionFactory sessionFactory;

  public static void main(String[] args) {
    // HINT : If you find logging too verbose - you can alter logging level in logback.xml to INFO

    sessionFactory = new DefaultSessionFactoryBuilder("remote").createSessionFactory();
    sessionDemo();
    repositoryDemo();
    queryDemo();
  }

  public static void sessionDemo() {
    System.out.println("===== ===== ===== ===== ===== SESSION ===== ===== ===== ===== ===== ");
    Session session = sessionFactory.openSession();
    session.getTransaction().begin();
    Person person = findPerson(3L);
    System.out.println(person);
    person.getNotes().forEach(System.out::println);
  }

  public static void repositoryDemo() {
    System.out.println("===== ===== ===== ===== ===== REPOSITORY ===== ===== ===== ===== ===== ");
    RepositoryBuilder builder = new RepositoryBuilder(sessionFactory);

    NoteRepository noteRepo = builder.buildRepository(NoteRepository.class, Note.class);
    PersonRepository personRepository = builder.buildRepository(PersonRepository.class, Person.class);

    noteRepo.findAllByIdLessThanOrderByIdDesc(4L)
        .forEach(System.out::println);

    personRepository.findAllByFirstNameOrLastNameOrderByIdDesc("Bob", "Doe")
        .forEach(System.out::println);
  }

  public static void queryDemo() {
    System.out.println("===== ===== ===== ===== ===== QUERY ===== ===== ===== ===== ===== ");
    var session = sessionFactory.openSession();
    var sql = """
        SELECT
        	p.id "Person ID",
        	p.first_name "First Name",
        	p.last_name "Last Name",
        	COUNT(person_id)  "Count of notes",
        	SUM(LENGTH(body))  "Total size of notes"
        FROM notes n
        JOIN persons p ON P.id = n.person_id
        GROUP BY p.id
        """;
    var query = session.createNativeQuery(sql, NoteStats.class);
    query.getResultList().forEach(System.out::println);
  }


  private static Person findPerson(Long id) {
    Session session = sessionFactory.openSession();
    Transaction transaction = session.getTransaction();
    try {
      transaction.begin();
      Person person = session.find(Person.class, id);
      session.getTransaction().commit();
      return person;
    } catch (Exception ex) {
      transaction.rollback();
      throw new RuntimeException("Unable to execute action in transaction", ex);
    }
  }

}
