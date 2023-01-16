package com.app.booking.Repository;

import com.app.booking.Entities.City;
import com.app.booking.Entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    // getting al the hotels that are not approved
    List<Hotel> findAllByIsApprovedFalse();

    // getting all the hotels that are approved
    List<Hotel> findAllByIsApprovedTrue();

    // getting all the hotels that are approved and in a specific city
    List<Hotel> findAllByIsApprovedTrueAndCity(City city);
    // getting the hotels by manager id
    List<Hotel> findAllByManagerId(Long id);
}
