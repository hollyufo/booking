package com.app.booking.Repository;

import com.app.booking.Entities.Hotel;
import com.app.booking.Entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    // getting all the rooms of a specific hotel
    List<Room> findAllByHotel(Hotel hotel);

    // getting all the rooms that hotel is approved
    List<Room> findAllByHotelIsApprovedTrue();
}

