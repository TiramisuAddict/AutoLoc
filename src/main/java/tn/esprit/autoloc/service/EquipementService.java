package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.EquipementRepository;

import java.util.List;

public class EquipementService implements IEquipementService{

    EquipementRepository equipementRepository;
    
    @Override
    public List<Equipement> retrieveAllEquipements() {
        return (List<Equipement>) equipementRepository.findAll();
    }

    @Override
    public Equipement addEquipement(Equipement c) {
        return equipementRepository.save(c);
    }

    @Override
    public Equipement updateEquipement(Equipement c) {
        return equipementRepository.save(c);
    }

    @Override
    public Equipement retrieveEquipement(Long idEquipement) {
        return  equipementRepository.findById(idEquipement).orElse(null);
    }

    @Override
    public void removeEquipement(Long idEquipement) {
        equipementRepository.deleteById(idEquipement);
    }

    @Override
    public List<Equipement> addEquipements(List<Equipement> Equipements) {
        return (List<Equipement>) equipementRepository.saveAll(Equipements);
    }
}
