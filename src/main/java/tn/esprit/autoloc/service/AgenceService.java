
package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.AgenceRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgenceService implements IAgenceService {

    private final AgenceRepository agenceRepository;

    public AgenceService(AgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }

    @Override
    public List<Agence> retrieveAllAgences() {
        List<Agence> agences = new ArrayList<>();
        agenceRepository.findAll().forEach(agences::add);
        return agences;
    }

    @Override
    public Agence addAgence(Agence a) {
        return agenceRepository.save(a);
    }

    @Override
    public Agence updateAgence(Agence a) {
        return agenceRepository.save(a);
    }

    @Override
    public Agence retrieveAgence(Long idAgence) {
        return agenceRepository.findById(idAgence).orElse(null);
    }

    @Override
    public void removeAgence(Long idAgence) {
        agenceRepository.deleteById(idAgence);
    }

    @Override
    public List<Agence> addAgences(List<Agence> agences) {
        List<Agence> result = new ArrayList<>();
        agenceRepository.saveAll(agences).forEach(result::add);
        return result;
    }
}
