package br.ufrn.residenciaimd.schedulemanager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.ufrn.residenciaimd.schedulemanager.entities.Judge;

@Repository
public interface JudgeRepository extends CrudRepository<Judge, Integer> {

    Optional<Judge> findById(Long id);

    List<Judge> findByNameContaining(String name);
}
