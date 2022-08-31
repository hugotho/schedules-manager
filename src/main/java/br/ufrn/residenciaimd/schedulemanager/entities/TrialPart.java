package br.ufrn.residenciaimd.schedulemanager.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor @AllArgsConstructor
public class TrialPart {
    
    @EmbeddedId
    private TrialPartPK id;

    @ManyToOne
    @MapsId("trialId")
    @JoinColumn(name = "trial_id")
    private Trial trial;

    @ManyToOne
    @MapsId("partId")
    @JoinColumn(name = "part_id")
    private Part part;
}
