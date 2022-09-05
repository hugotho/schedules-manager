package br.ufrn.residenciaimd.schedulemanager.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ufrn.residenciaimd.schedulemanager.entities.Part;
import br.ufrn.residenciaimd.schedulemanager.repositories.PartRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PartService {

    private final PartRepository partRepository;

    public List<Part> getPartsByNameContaining(String name) {
        return partRepository.findByNameContaining(name);
    }
}
