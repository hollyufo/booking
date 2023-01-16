package com.app.booking.Resource;

import com.app.booking.Config.JwtService;
import com.app.booking.Entities.AppUser;
import com.app.booking.Entities.City;
import com.app.booking.Entities.Hotel;
import com.app.booking.Service.CityService;
import com.app.booking.Service.HotelService;
import com.app.booking.Service.UserService;
import com.app.booking.vo.hotelVo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Manager")
@AllArgsConstructor
public class ManagerController {
    private final HotelService hotelService;
    private final UserService userService;
    private final JwtService jwtService;

    private final CityService cityService;
    // getting hotels for logged in manager
    @GetMapping("/hotels")
    public List<Hotel> getHotels(@RequestHeader("Authorization") String token) {
           String email = jwtService.extractUsername(token.substring(7));
           AppUser user = userService.getUserByEmail(email);
           return hotelService.getHotelsByManager(user.getId());
    }
    // adding a hotel for logged in manager
    @PostMapping("/hotels")
    public Hotel addHotel(@RequestBody hotelVo hotelVo, Principal principal) {
        String email = principal.getName();
        System.out.println(email);
        AppUser user = userService.getUserByEmail(email);
        // getting city by id and cating to Long
        City city = cityService.getCityById(Long.parseLong(hotelVo.getCity()));
        // creating a new hotel
        Hotel hotel = new Hotel();
        hotel.setName(hotelVo.getName());
        hotel.setCity(city);
        hotel.setManager(user);
        hotel.setApproved(false);
        hotel.setAddress(hotelVo.getAddress());
        hotel.setImage(hotelVo.getImage());
        // saving hotel
        return hotelService.saveHotel(hotel);
    }
    // getting all the cities
    @GetMapping("/cities")
    public List<City> getCities() {
        return cityService.getAllCities();
    }
    // getting all the hotel rooms for a specific hotel

}
