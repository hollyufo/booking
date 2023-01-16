package com.app.booking.Resource;


import com.app.booking.Dto.ReservationDto;
import com.app.booking.Entities.Hotel;
import com.app.booking.Entities.Reservation;
import com.app.booking.Entities.Room;
import com.app.booking.Service.HotelService;
import com.app.booking.Service.ResevationService;
import com.app.booking.Service.RoomService;
import com.app.booking.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final HotelService hotelService;
    private final RoomService roomService;
    private final ResevationService reservationService;

    // get all hotels that are approved
    @GetMapping("/hotels")
    public List<Hotel> getAllHotels() {
        return hotelService.getAllApproved();
    }

    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/availableRooms")
    public List<Room> getAvailableRooms(@RequestBody ReservationDto reservationDto) {
        return reservationService.getAvailableRooms(reservationDto);
    }
}
