package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.repository.MaintenanceRepository;

import java.util.List;

public class MaintenanceService implements IMaintenanceService{

    MaintenanceRepository maintenanceRepository;
    
    @Override
    public List<Maintenance> retrieveAllMaintenances() {
        return (List<Maintenance>) maintenanceRepository.findAll();
    }

    @Override
    public Maintenance addMaintenance(Maintenance c) {
        return maintenanceRepository.save(c);
    }

    @Override
    public Maintenance updateMaintenance(Maintenance c) {
        return maintenanceRepository.save(c);
    }

    @Override
    public Maintenance retrieveMaintenance(Long idMaintenance) {
        return  maintenanceRepository.findById(idMaintenance).orElse(null);
    }

    @Override
    public void removeMaintenance(Long idMaintenance) {
        maintenanceRepository.deleteById(idMaintenance);
    }

    @Override
    public List<Maintenance> addMaintenances(List<Maintenance> Maintenances) {
        return (List<Maintenance>) maintenanceRepository.saveAll(Maintenances);
    }
}
