package com.app.booking.Repository;

import com.app.booking.Entities.*;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByClient(AppUser client);
    List<Reservation> findByRoom(Room room);
    List<Reservation> findByRoomHotel(Hotel hotel);

    // find all that are Approved
    List<Reservation> findByReservationStatus(ReservationStatus reservationStatus);

    @Query("SELECT r FROM Room r WHERE r NOT IN (SELECT re.room FROM Reservation re WHERE (re.startDate BETWEEN :startDate AND :endDate) OR (re.endDate BETWEEN :startDate AND :endDate))")
    List<Room> findRoomsWithoutReservationInPeriod(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    List<Reservation>findByStartDateAndEndDate(Date startDate, Date endDate);
}
