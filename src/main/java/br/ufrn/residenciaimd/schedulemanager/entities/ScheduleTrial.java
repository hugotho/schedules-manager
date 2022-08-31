package br.ufrn.residenciaimd.schedulemanager.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor @AllArgsConstructor
public class ScheduleTrial {
    
    @EmbeddedId
    private ScheduleTrialPK id;

    @ManyToOne
    @MapsId("scheduleId")
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @ManyToOne
    @MapsId("trialId")
    @JoinColumn(name = "trial_id")
    private Trial trial;

    @Getter @Setter private Integer order;
}
