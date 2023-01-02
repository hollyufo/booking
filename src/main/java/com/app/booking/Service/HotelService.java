package com.app.booking.Service;


import com.app.booking.Entities.Hotel;
import com.app.booking.Repository.HotelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;

    // get all hotels that are approved
    public List<Hotel> getAllApproved(){
        return hotelRepository.findAllByIsApprovedTrue();
    }
    // get all hotels that are not approved
    public List<Hotel> getAllNotApproved(){
        return hotelRepository.findAllByIsApprovedFalse();
    }
    // get all hotels that are approved and in a specific city
    public List<Hotel> getAllApprovedByCity(){
        return hotelRepository.findAllByIsApprovedTrue();
    }
    // save hotel
    public Hotel saveHotel(Hotel hotel) {
        hotel.setApproved(false);
        return hotelRepository.save(hotel);
    }
    // find hotel by id
    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id).orElseThrow(() -> new RuntimeException("Hotel not found"));
    }
    // delete hotel
    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }
    // approve hotel
    public void approveHotel(Long id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new RuntimeException("Hotel not found"));
        hotel.setApproved(true);
        hotelRepository.save(hotel);
    }
}
