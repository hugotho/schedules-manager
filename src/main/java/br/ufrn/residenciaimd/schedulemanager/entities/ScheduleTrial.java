package br.ufrn.residenciaimd.schedulemanager.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Data;

@Data
@Entity
public class ScheduleTrial {

    @EmbeddedId
    private ScheduleTrialPK id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("scheduleId")
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("trialId")
    @JoinColumn(name = "trial_id")
    private Trial trial;

    private Integer trialOrder;
}
