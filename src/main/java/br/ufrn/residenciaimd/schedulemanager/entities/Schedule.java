package br.ufrn.residenciaimd.schedulemanager.entities;

import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    @Column(name = "schedule_date")
    @Getter @Setter private Date date;

    @OneToMany(mappedBy = "schedule")
    private Set<ScheduleTrials> scheduleTrials = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "adjudicatingBodyId")
    @Getter private AdjudicatingBody adjudicatingBody;

    @Override
    public boolean equals(Object object) {
        if (object instanceof Schedule) {
            return this.id == ((Schedule)object).id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, adjudicatingBody);
    }
}
