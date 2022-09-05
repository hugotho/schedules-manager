package br.ufrn.residenciaimd.schedulemanager.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor @NoArgsConstructor
public class Trial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private Long id;

    @ManyToOne
    @JoinColumn(name = "rapporteurId")
    @Getter @Setter private Judge rapporteur;

    @Getter @Setter private String number;
    
    @Column(name = "abstract", length = 2047)
    @Getter @Setter private String abstractText;

    @OneToMany(mappedBy = "trial")
    @JsonManagedReference
    @Getter private Set<TrialParts> trialParts = new HashSet<>();

    @OneToMany(mappedBy = "trial")
    private Set<ScheduleTrials> scheduleTrials = new HashSet<>();
}
