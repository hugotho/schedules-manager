package br.ufrn.residenciaimd.schedulemanager.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor @AllArgsConstructor
public class ScheduleTrials {

    @EmbeddedId
    @Getter private ScheduleTrialsPK id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("scheduleId")
    @JoinColumn(name = "schedule_id")
    @Getter @Setter private Schedule schedule;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("trialId")
    @JoinColumn(name = "trial_id")
    @Getter @Setter private Trial trial;

    @Getter @Setter private Integer trialOrder;
}
