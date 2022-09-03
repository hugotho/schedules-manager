package br.ufrn.residenciaimd.schedulemanager.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Trial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "judgeId")
    private Judge rapporteur;

    private String number;

    @Column(name = "abstract")
    private String abstractText;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Part> parts = new HashSet<>();

    @OneToMany(mappedBy = "trial")
    private Set<ScheduleTrial> scheduleTrials = new HashSet<>();
}
