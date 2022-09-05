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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor @AllArgsConstructor
public class Judge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private Long id;

    @Column(name = "is_minister")
    @Getter @Setter private Boolean isMinister;

    @Getter @Setter private String name;

    @OneToMany(mappedBy = "president")
    private Set<AdjudicatingBody> presidedAdjudicatingBodies = new HashSet<>();

    @ManyToMany(mappedBy = "judges")
    private Set<AdjudicatingBody> adjudicatingBodies = new HashSet<>();

    @OneToMany(mappedBy = "rapporteur")
    private Set<Trial> trials = new HashSet<>();
}
