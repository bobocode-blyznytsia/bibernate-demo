package com.bobocode.blyznytsia.bibernate.demo.repository;

import com.bobocode.blyznytsia.bibernate.demo.model.Person;
import com.bobocode.blyznytsia.bibernate.repository.BibernateReadonlyRepository;
import java.util.List;
import java.util.Optional;

public interface PersonRepository extends BibernateReadonlyRepository<Person, Long> {
  Optional<Person> findOneById(Long id);
  List<Person> findAllByFirstNameOrLastNameOrderByIdDesc(String firstName, String lastName);


}
