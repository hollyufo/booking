package com.app.booking.Repository;

import com.app.booking.Entities.City;
import com.app.booking.Entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    // getting al the hotels that are not approved
    List<Hotel> findAllByIsApprovedFalse();

    // getting all the hotels that are approved

    List<Hotel> findAllByIsApprovedTrue();

    // getting all the hotels that are approved and in a specific city
    List<Hotel> findAllByIsApprovedTrueAndCity(City city);

}
