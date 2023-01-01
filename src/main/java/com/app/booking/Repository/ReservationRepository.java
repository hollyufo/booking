package com.app.booking.Repository;

import com.app.booking.Entities.*;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByClient(AppUser client);
    List<Reservation> findByRoom(Room room);
    List<Reservation> findByRoomHotel(Hotel hotel);

    // find all that are Approved
    List<Reservation> findByReservationStatus(ReservationStatus reservationStatus);

}
