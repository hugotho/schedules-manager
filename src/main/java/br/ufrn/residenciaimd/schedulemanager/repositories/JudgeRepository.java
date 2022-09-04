package br.ufrn.residenciaimd.schedulemanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.ufrn.residenciaimd.schedulemanager.entities.Judge;

@Repository
public interface JudgeRepository extends CrudRepository<Judge, Integer> {

    List<Judge> findByNameContaining(String name); 
}
