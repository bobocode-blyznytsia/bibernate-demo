package com.bobocode.blyznytsia.bibernate.demo.repository;

import com.bobocode.blyznytsia.bibernate.demo.model.Note;
import com.bobocode.blyznytsia.bibernate.repository.BibernateReadonlyRepository;
import java.util.List;

public interface NoteRepository extends BibernateReadonlyRepository<Note, Long> {

  List<Note> findAllByIdLessThanOrderByIdDesc(Long id);

}
