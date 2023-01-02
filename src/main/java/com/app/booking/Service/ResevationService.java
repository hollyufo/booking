package com.app.booking.Service;


import com.app.booking.Entities.Hotel;
import com.app.booking.Entities.Reservation;
import com.app.booking.Entities.ReservationStatus;
import com.app.booking.Repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ResevationService {

    private final ReservationRepository reservationRepository;

    // save reservation
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
    // approve reservation
    public void approveReservation(Long id) {
        // find reservation
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation not found"));
        // set approved to true
        reservation.setReservationStatus(ReservationStatus.APPROVED);
        // save reservation
        reservationRepository.save(reservation);
    }
    // reject reservation
    public void rejectReservation(Long id) {
        // find reservation
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation not found"));
        // set approved to true
        reservation.setReservationStatus(ReservationStatus.REJECTED);
        // save reservation
        reservationRepository.save(reservation);
    }
    // get all reservations by status
    public List<Reservation> getReservationsByStatus(ReservationStatus reservationStatus) {
        return reservationRepository.findByReservationStatus(reservationStatus);
    }
    // get all reservations by hotel
    public List<Reservation> getReservationsByHotel(Hotel hotel) {
        return reservationRepository.findByRoomHotel(hotel);
    }
    // find reservation by id
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation not found"));
    }
    // find reservation by user
}
