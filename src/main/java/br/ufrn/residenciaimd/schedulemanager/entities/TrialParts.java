package br.ufrn.residenciaimd.schedulemanager.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.ufrn.residenciaimd.schedulemanager.enums.PartEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor @AllArgsConstructor
public class TrialParts {

    @EmbeddedId
    @JsonIgnore
    @Getter private TrialPartsPK id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("trialId")
    @JoinColumn(name = "trial_id")
    @JsonBackReference
    @Getter @Setter private Trial trial;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("partId")
    @JoinColumn(name = "part_id")
    @JsonManagedReference
    @Getter @Setter private Part part;

    @Enumerated
    @Getter @Setter private PartEnum type;
}
