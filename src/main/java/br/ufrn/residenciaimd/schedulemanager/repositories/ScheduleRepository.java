package br.ufrn.residenciaimd.schedulemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufrn.residenciaimd.schedulemanager.entities.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

}
