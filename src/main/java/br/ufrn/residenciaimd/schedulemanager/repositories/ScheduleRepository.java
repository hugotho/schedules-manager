package br.ufrn.residenciaimd.schedulemanager.repositories;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufrn.residenciaimd.schedulemanager.entities.Judge;
import br.ufrn.residenciaimd.schedulemanager.entities.Part;
import br.ufrn.residenciaimd.schedulemanager.entities.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    
    Optional<Schedule> findByDate(Date date);

    Optional<Schedule> findByScheduleTrialsTrialRapporteur(Judge rapporteur);

    List<Schedule> findByScheduleTrialsTrialTrialPartsPart(Part part);
}
