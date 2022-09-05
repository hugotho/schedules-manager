package br.ufrn.residenciaimd.schedulemanager.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.ufrn.residenciaimd.schedulemanager.entities.Judge;
import br.ufrn.residenciaimd.schedulemanager.entities.Part;
import br.ufrn.residenciaimd.schedulemanager.entities.Schedule;
import br.ufrn.residenciaimd.schedulemanager.repositories.ScheduleRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public Schedule getScheduleById(Integer scheduleId) {
        Optional<Schedule> schedule = scheduleRepository.findById(scheduleId);
        if (schedule.isPresent())
            return schedule.get();
        return null;
    }

    public Schedule getScheduleByDate(Date date) {
        Optional<Schedule> schedule = scheduleRepository.findByDate(date);
        if (schedule.isPresent())
            return schedule.get();
        return null;
    }

    public Schedule getScheduleByTrialRapporteur(Judge rapporteur) {
        Optional<Schedule> schedule = scheduleRepository.findByScheduleTrialsTrialRapporteur(rapporteur);
        if (schedule.isPresent())
            return schedule.get();
        return null;
    }

    public List<Schedule> getScheduleByTrialPart(Part part) {
        List<Schedule> rawList = scheduleRepository.findByScheduleTrialsTrialTrialPartsPart(part);
        
        // Drops duplicateds
        return rawList.stream().distinct().collect(Collectors.toList());
    }

    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public Schedule updateSchedule(int scheduleId, Schedule changedSchedule) {
        Optional<Schedule> schedule = scheduleRepository.findById(scheduleId);
        
        if (schedule.isPresent()) {
            Schedule tempSchedule = schedule.get();
            tempSchedule.setDate(changedSchedule.getDate());
            return scheduleRepository.save(tempSchedule);
        }
        return null;
    }

    public boolean deleteSchedule(int scheduleId) {
        Optional<Schedule> schedule = scheduleRepository.findById(scheduleId);
        if (schedule.isPresent()) {
            scheduleRepository.delete(schedule.get());
            return true;
        }
        return false;
    }
}
