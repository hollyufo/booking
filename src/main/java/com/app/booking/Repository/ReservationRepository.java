package com.app.booking.Repository;

import com.app.booking.Entities.AppUser;
import com.app.booking.Entities.Hotel;
import com.app.booking.Entities.Reservation;
import com.app.booking.Entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // getting all the reservations of a specific user
    List<Reservation> findAllByAppUser(AppUser appUser);

    // getting all the reservations of a specific hotel
    List<Reservation> findAllByHotel(Hotel hotel);

    // getting all the reservations of a specific room
    List<Reservation> findAllByRoom(Room room);

    // getting all the reservations of a specific hotel and a specific user
    List<Reservation> findAllByHotelAndAppUser(Hotel hotel, AppUser appUser);

    // getting all the reservations of a specific room and a specific user
    List<Reservation> findAllByRoomAndAppUser(Room room, AppUser appUser);

    // getting all the reservations of a specific hotel and a specific room
    List<Reservation> findAllByHotelAndRoom(Hotel hotel, Room room);

    // getting all the reservations of a specific hotel and a specific room and a specific user
    List<Reservation> findAllByHotelAndRoomAndAppUser(Hotel hotel, Room room, AppUser appUser);

    // getting all the reservations of a specific hotel and a specific room and a specific user and a specific date
    List<Reservation> findAllByHotelAndRoomAndAppUserAndDate(Hotel hotel, Room room, AppUser appUser, Date date);

    // getting all the reservations of a specific hotel and a specific room and a specific user and a specific date and a specific status
    List<Reservation> findAllByHotelAndRoomAndAppUserAndDateAndStatus(Hotel hotel, Room room, AppUser appUser, Date date, String status);

    // getting all the reservations of a specific hotel and a specific room and a specific user and a specific date and a specific status and a specific number of nights
    List<Reservation> findAllByHotelAndRoomAndAppUserAndDateAndStatusAndNights(Hotel hotel, Room room, AppUser appUser, Date date, String status, int nights);

    // getting all the reservations of a specific hotel and a specific room and a specific user and a specific date and a specific status and a specific number of nights and a specific number of adults
    List<Reservation> findAllByHotelAndRoomAndAppUserAndDateAndStatusAndNightsAndAdults(Hotel hotel, Room room, AppUser appUser, Date date, String status, int nights, int adults);

    // getting
}
