package br.ufrn.residenciaimd.schedulemanager.repositories;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import br.ufrn.residenciaimd.schedulemanager.entities.Trial;

public interface TrialRepository extends  JpaRepository<Trial, Integer>{
    
    public Page<Trial> findByScheduleId(Long scheduleId, Pageable page);
}
