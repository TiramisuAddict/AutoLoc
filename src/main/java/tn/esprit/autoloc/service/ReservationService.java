package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.repository.ReservationRepository;

import java.util.List;

public class ReservationService implements IReservationService{

    ReservationRepository reservationRepository;
    
    @Override
    public List<Reservation> retrieveAllReservations() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public Reservation addReservation(Reservation c) {
        return reservationRepository.save(c);
    }

    @Override
    public Reservation updateReservation(Reservation c) {
        return reservationRepository.save(c);
    }

    @Override
    public Reservation retrieveReservation(Long idReservation) {
        return  reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public void removeReservation(Long idReservation) {
        reservationRepository.deleteById(idReservation);
    }

    @Override
    public List<Reservation> addReservations(List<Reservation> Reservations) {
        return (List<Reservation>) reservationRepository.saveAll(Reservations);
    }
}
