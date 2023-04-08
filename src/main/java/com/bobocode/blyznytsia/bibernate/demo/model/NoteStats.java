package com.bobocode.blyznytsia.bibernate.demo.model;

import com.bobocode.blyznytsia.bibernate.annotation.Column;
import com.bobocode.blyznytsia.bibernate.annotation.Entity;
import com.bobocode.blyznytsia.bibernate.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "notes")
@Getter
@Setter
@ToString
public class NoteStats {
  @Column(name = "Person ID")
  private Long personId;
  @Column(name = "First Name")
  private String firstName;
  @Column(name = "Last Name")
  private String lastName;
  @Column(name = "Count of notes")
  private Long totalNotes;
  @Column(name = "Total size of notes")
  private Long totalNotesSize;
}
