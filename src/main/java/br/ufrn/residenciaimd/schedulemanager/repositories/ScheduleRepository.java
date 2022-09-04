package br.ufrn.residenciaimd.schedulemanager.repositories;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufrn.residenciaimd.schedulemanager.entities.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    
    Schedule findByDate(Date date);
}
