package br.ufrn.residenciaimd.schedulemanager.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TrialPartPK implements Serializable {
    
    @Column(name = "trial_id")
    private Long trialId;

    @Column(name = "part_id")
    private Long partId;
}
