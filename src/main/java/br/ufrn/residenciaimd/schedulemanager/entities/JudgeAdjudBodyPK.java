package br.ufrn.residenciaimd.schedulemanager.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class JudgeAdjudBodyPK implements Serializable {

    @Column(name = "judge_id")
    private Long judgeId;
    
    @Column(name = "adjud_body_id")
    private Long adjudBobyId;
}
