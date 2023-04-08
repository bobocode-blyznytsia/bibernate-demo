package com.bobocode.blyznytsia.bibernate.demo.model;

import com.bobocode.blyznytsia.bibernate.annotation.Entity;
import com.bobocode.blyznytsia.bibernate.annotation.Id;
import com.bobocode.blyznytsia.bibernate.annotation.ManyToOne;
import com.bobocode.blyznytsia.bibernate.annotation.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name="notes")
@ToString
public class Note {

    @Id
    private Long id;

    private String body;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne(joinColumnName = "person_id")
    private Person person;

}
