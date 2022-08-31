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
public class JudgeAdjudBody {
    
    @EmbeddedId
    private JudgeAdjudBodyPK id;

    @ManyToOne
    @MapsId("judgeId")
    @JoinColumn(name = "judge_id")
    private Judge judge;

    @ManyToOne
    @MapsId("adjudBodyId")
    @JoinColumn(name = "adjud_body_id")
    private AdjudicatingBody adjudicatingBody;
}
