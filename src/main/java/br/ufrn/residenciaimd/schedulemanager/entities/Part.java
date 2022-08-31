package br.ufrn.residenciaimd.schedulemanager.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor @AllArgsConstructor
public class Part {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private  Long id;

    @Getter @Setter private String name;

    @OneToMany(mappedBy = "part")
    private Set<TrialPart> trialParts = new HashSet<>();
}
