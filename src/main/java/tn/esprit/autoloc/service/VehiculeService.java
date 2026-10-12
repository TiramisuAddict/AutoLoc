package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.util.List;

public class VehiculeService implements IVehiculeService{

    VehiculeRepository vehiculeRepository;
    
    @Override
    public List<Vehicule> retrieveAllVehicules() {
        return (List<Vehicule>) vehiculeRepository.findAll();
    }

    @Override
    public Vehicule addVehicule(Vehicule c) {
        return vehiculeRepository.save(c);
    }

    @Override
    public Vehicule updateVehicule(Vehicule c) {
        return vehiculeRepository.save(c);
    }

    @Override
    public Vehicule retrieveVehicule(Long idVehicule) {
        return  vehiculeRepository.findById(idVehicule).orElse(null);
    }

    @Override
    public void removeVehicule(Long idVehicule) {
        vehiculeRepository.deleteById(idVehicule);
    }

    @Override
    public List<Vehicule> addVehicules(List<Vehicule> Vehicules) {
        return (List<Vehicule>) vehiculeRepository.saveAll(Vehicules);
    }
}
