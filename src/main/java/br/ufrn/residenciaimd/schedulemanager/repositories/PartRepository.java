package br.ufrn.residenciaimd.schedulemanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufrn.residenciaimd.schedulemanager.entities.Part;

public interface PartRepository extends CrudRepository<Part, Integer> {

    List<Part> findByNameContaining(String name);
}
