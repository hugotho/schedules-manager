package br.ufrn.residenciaimd.schedulemanager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.ufrn.residenciaimd.schedulemanager.entities.Part;

public interface PartRepository extends CrudRepository<Part, Integer> {

    List<Part> findByNameContaining(String name);

    Optional<Part> findById(Long id);
}
