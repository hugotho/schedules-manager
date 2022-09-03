package br.ufrn.residenciaimd.schedulemanager.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Judge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_minister")
    private Boolean isMinister;

    private String name;

    @ManyToMany(mappedBy = "judges")
    private Set<AdjudicatingBody> adjudicatingBodies = new HashSet<>();

    @OneToMany(mappedBy = "rapporteur")
    private Set<Trial> trials = new HashSet<>();
}
