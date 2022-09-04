package br.ufrn.residenciaimd.schedulemanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufrn.residenciaimd.schedulemanager.entities.Trial;

@Repository
public interface TrialRepository extends JpaRepository<Trial, Integer> {

    public List<Trial> findByScheduleTrialsScheduleId(Long scheduleId);
}
