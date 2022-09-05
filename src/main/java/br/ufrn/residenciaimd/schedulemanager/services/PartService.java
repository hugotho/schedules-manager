package br.ufrn.residenciaimd.schedulemanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.ufrn.residenciaimd.schedulemanager.entities.Part;
import br.ufrn.residenciaimd.schedulemanager.repositories.PartRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PartService {

    private final PartRepository partRepository;

    public Part getPartById(Long partId) {
        Optional<Part> part = partRepository.findById(partId);
        if (part.isPresent())
            return part.get();
        return null;
    }

    public List<Part> getPartsByNameContaining(String name) {
        return partRepository.findByNameContaining(name);
    }
}
