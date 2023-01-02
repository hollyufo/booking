package com.app.booking.Resource;


import com.app.booking.Entities.AppUser;
import com.app.booking.Entities.Hotel;
import com.app.booking.Service.HotelService;
import com.app.booking.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Admin")
@AllArgsConstructor
public class AdminController {

    private final HotelService hotelService;

    private final UserService userService;

    // get all hotels that are not approved
    @GetMapping("/hotels/notApproved")
    public List<Hotel> getAllNotApproved() {
        return hotelService.getAllNotApproved();
    }
    @PostMapping("/hotels/approve")
    public void approveHotel(@RequestBody Hotel hotel) {
        hotelService.approveHotel(hotel.getId());
    }

    // update A user Role
    @PostMapping("/users/update")
    public void updateUserRole(@RequestBody AppUser user) {
        userService.updateUserRole(user);
    }

    // get all users that are managers
    @GetMapping("/users/managers")
    public List<AppUser> getAllManagers() {
        return userService.getAllManagers();
    }
    // get all users that are customers
    @GetMapping("/users/customers")
    public List<AppUser> getAllCustomers() {
        return userService.getAllCustomers();
    }
    // get all users that are banned
    @GetMapping("/users/banned")
    public List<AppUser> getAllBanned() {
        return userService.getAllBanned();
    }
    // ban a user
    @PostMapping("/users/ban")
    public void banUser(@RequestBody AppUser user) {
        userService.banUser(user.getId());
    }
}
