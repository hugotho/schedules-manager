package br.ufrn.residenciaimd.schedulemanager.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Judge {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private Long id;

    @Column(name = "is_minister")
    @Getter @Setter private Boolean isMinister;

    @Getter @Setter private String name;

    @OneToMany(mappedBy = "judge")
    private Set<JudgeAdjudBody> judgeAdjudBodies = new HashSet<>();
}
