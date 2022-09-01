package br.ufrn.residenciaimd.schedulemanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.ufrn.residenciaimd.schedulemanager.repositories.TrialRepository;
import br.ufrn.residenciaimd.schedulemanager.entities.Trial;

@Service
public class TrialService {
    
    @Autowired
    TrialRepository trialRepository;

    public List<Trial> listTrialsByScheduleId(Long scheduleId, int page, int size){
        return trialRepository.findByScheduleId(scheduleId, PageRequest.of(page, size)).toList();
    }
}
