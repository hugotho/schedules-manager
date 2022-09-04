package br.ufrn.residenciaimd.schedulemanager.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufrn.residenciaimd.schedulemanager.entities.Schedule;
import br.ufrn.residenciaimd.schedulemanager.repositories.ScheduleRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public Schedule getScheduleByDate(Date date) {
        return scheduleRepository.findByDate(date);
    }

    public Schedule getScheduleById(int scheduleId) {
        Optional<Schedule> schedule = scheduleRepository.findById(scheduleId);
        if (schedule.isPresent())
            return schedule.get();
        return null;
    }

    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public Schedule updateSchedule(int scheduleId, Schedule changedSchedule) {
        Optional<Schedule> schedule = scheduleRepository.findById(scheduleId);
        // Check if the Schedule exists
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
