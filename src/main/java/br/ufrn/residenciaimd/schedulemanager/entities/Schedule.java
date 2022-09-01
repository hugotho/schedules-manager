package br.ufrn.residenciaimd.schedulemanager.entities;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor @AllArgsConstructor
public class Schedule {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private Long id;

    @Getter @Setter private Timestamp date;

    @OneToMany(mappedBy = "schedule")
    private Set<ScheduleTrial> scheduleTrials = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "adjudicatingBodyId")
    private AdjudicatingBody adjudicatingBody;
}
