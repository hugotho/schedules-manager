package br.ufrn.residenciaimd.schedulemanager.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ufrn.residenciaimd.schedulemanager.entities.Judge;
import br.ufrn.residenciaimd.schedulemanager.repositories.JudgeRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JudgeService {
    
    private final JudgeRepository judgeRepository;

    public List<Judge> getJudgesByNameContaining(String name) {
        return judgeRepository.findByNameContaining(name);
    } 
}
