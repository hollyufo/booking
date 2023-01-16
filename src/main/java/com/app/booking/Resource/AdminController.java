package com.app.booking.Resource;


import com.app.booking.Entities.AppUser;
import com.app.booking.Entities.Hotel;
import com.app.booking.Entities.Role;
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
    @GetMapping("/hotels/{id}")
    public Hotel getHotelById(@PathVariable Long id) {
       return hotelService.setapproved(id);
    }
    @GetMapping("/hotels")
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    // update A user Role
    @GetMapping("/users/update/{id}/{role}")
    public void updateUserRole(@PathVariable Long id, @PathVariable String role) {
        AppUser user =userService.getUserById(id);
        if(role.equals("USER")){
            user.setRole(Role.USER);
        }else if(role.equals("MANAGER")){
            user.setRole(Role.MANAGER);
        }else if(role.equals("ADMIN")){
            user.setRole(Role.ADMIN);
        }
        userService.saveUser(user);
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
    @GetMapping("/users/ban/{id}")
    public void banUser(@PathVariable Long id) {
        userService.banUser(id);
    }
    @GetMapping("/users")
    public List<AppUser> getAllUsers() {
        return userService.getAllUsers();
    }
    // getting a single user with id
    @GetMapping("/users/view/{id}")
    public AppUser getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
