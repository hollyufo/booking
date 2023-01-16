package com.app.booking.Service;


import com.app.booking.Dto.ReservationDto;
import com.app.booking.Entities.Hotel;
import com.app.booking.Entities.Reservation;
import com.app.booking.Entities.ReservationStatus;
import com.app.booking.Entities.Room;
import com.app.booking.Repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ResevationService {

    private final ReservationRepository reservationRepository;
    private final RoomService roomService;

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
    public List<Room> getAvailableRooms(ReservationDto reservationDto) {
        List<Reservation> reservations = reservationRepository.findByStartDateAndEndDate(reservationDto.getStartDate(), reservationDto.getEndDate());
        List<Room> reservedRooms = reservations.stream().map(Reservation::getRoom).collect(Collectors.toList());
        return roomService.findAll().stream().filter(room -> !reservedRooms.contains(room)).collect(Collectors.toList());
    }
}
