package com.bobocode.blyznytsia.bibernate.demo.model;

import com.bobocode.blyznytsia.bibernate.annotation.Entity;
import com.bobocode.blyznytsia.bibernate.annotation.Id;
import com.bobocode.blyznytsia.bibernate.annotation.OneToMany;
import com.bobocode.blyznytsia.bibernate.annotation.Table;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ToString(exclude = "notes")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "persons")
public class Person {

    @Id
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String team;

    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "person")
    private List<Note> notes = new ArrayList<>();

    public void addNote(Note note) {
        note.setPerson(this);
        notes.add(note);
    }

}
