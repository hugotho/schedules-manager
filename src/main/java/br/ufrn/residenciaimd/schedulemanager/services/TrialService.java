package br.ufrn.residenciaimd.schedulemanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.ufrn.residenciaimd.schedulemanager.repositories.TrialRepository;
import br.ufrn.residenciaimd.schedulemanager.entities.Trial;

@Service
public class TrialService {

    @Autowired
    TrialRepository trialRepository;

    public List<Trial> listTrialsByScheduleId(int scheduleId, int page, int size) {
        return trialRepository.findByScheduleTrialsScheduleId(
            scheduleId,
            PageRequest.of(page, size)
        ).toList();
    }

    public Trial getTrialById(int trialId){
        Optional<Trial> trial = trialRepository.findById(trialId);
        if (trial.isPresent())
            return trial.get();
        return null;
    }

    public Trial createTrial(Trial trial){

        return trialRepository.save(trial);
    }

    public Trial updateTrial(int trialId, Trial changedTrial){
        Optional<Trial> trial = trialRepository.findById(trialId);
        //Check if the Trial exists
        if (trial.isPresent()) {
            Trial tempTrial= trial.get();
            tempTrial.setRapporteur(changedTrial.getRapporteur());
            tempTrial.setNumber(changedTrial.getNumber());
            tempTrial.setAbstractText(changedTrial.getAbstractText());
            tempTrial.setParts(changedTrial.getParts());
            tempTrial.setScheduleTrials(changedTrial.getScheduleTrials());
            return trialRepository.save(tempTrial);
        }
        return null;
    }

    public boolean deleteTrial(int trialId){
        Optional<Trial> trial = trialRepository.findById(trialId);
        if (trial.isPresent()) {
            trialRepository.delete(trial.get());
            return true;
        }
        return false;
    }
}
