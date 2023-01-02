package com.app.booking.Service;

import com.app.booking.Entities.Hotel;
import com.app.booking.Entities.Room;
import com.app.booking.Repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;


    // get all rooms that are approved and in a specific hotel
    public List<Room> getAllApprovedByHotel(){
        return roomRepository.findAllByHotelIsApprovedTrue();
    }
    // save room
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }
    // find room by id
    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));
    }
    // get all rooms of a specific hotel
    public List<Room> getAllByHotel(Hotel hotel){
        return roomRepository.findAllByHotel(hotel);
    }
}
