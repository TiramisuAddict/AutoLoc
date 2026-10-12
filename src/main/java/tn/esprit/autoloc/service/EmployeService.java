package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.EmployeRepository;

import java.util.List;

public class EmployeService implements IEmployeService{

    EmployeRepository employeRepository;

    @Override
    public List<Employe> retrieveAllEmployes() {
        return (List<Employe>) employeRepository.findAll();
    }

    @Override
    public Employe addEmploye(Employe c) {
        return employeRepository.save(c);
    }

    @Override
    public Employe updateEmploye(Employe c) {
        return employeRepository.save(c);
    }

    @Override
    public Employe retrieveEmploye(Long idEmploye) {
        return  employeRepository.findById(idEmploye).orElse(null);
    }

    @Override
    public void removeEmploye(Long idEmploye) {
        employeRepository.deleteById(idEmploye);
    }

    @Override
    public List<Employe> addEmployes(List<Employe> Employes) {
        return (List<Employe>) employeRepository.saveAll(Employes);
    }
}
