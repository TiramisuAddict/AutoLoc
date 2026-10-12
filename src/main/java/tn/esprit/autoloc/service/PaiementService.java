package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.PaiementRepository;

import java.util.List;

public class PaiementService implements IPaiementService{

    PaiementRepository paiementRepository;
    
    @Override
    public List<Paiement> retrieveAllPaiements() {
        return (List<Paiement>) paiementRepository.findAll();
    }

    @Override
    public Paiement addPaiement(Paiement c) {
        return paiementRepository.save(c);
    }

    @Override
    public Paiement updatePaiement(Paiement c) {
        return paiementRepository.save(c);
    }

    @Override
    public Paiement retrievePaiement(Long idPaiement) {
        return  paiementRepository.findById(idPaiement).orElse(null);
    }

    @Override
    public void removePaiement(Long idPaiement) {
        paiementRepository.deleteById(idPaiement);
    }

    @Override
    public List<Paiement> addPaiements(List<Paiement> Paiements) {
        return (List<Paiement>) paiementRepository.saveAll(Paiements);
    }
}
