package br.ufrn.residenciaimd.schedulemanager.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ScheduleTrialPK implements Serializable {
    
    @Column(name = "schedule_id")
    private Long scheduleId;

    @Column(name = "trial_id")
    private Long trialId;
}
