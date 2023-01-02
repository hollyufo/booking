package com.app.booking.Service;

import com.app.booking.Entities.AppUser;
import com.app.booking.Repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final AppUserRepository appUserRepository;

    public AppUser saveUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    public AppUser getUserById(Long id) {
        return appUserRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    // get all users that are banned
    public List<AppUser> getAllBanned(){
        return appUserRepository.findAllByisBanned(true);
    }
    // get all users that are not banned
    public List<AppUser> getAllNotBanned(){
        return appUserRepository.findAllByisBanned(false);
    }
    // get all users that are managers
    public List<AppUser> getAllManagers(){
        return appUserRepository.findAllByRole("MANAGER");
    }
    // get all users that are customers
    public List<AppUser> getAllCustomers(){
        return appUserRepository.findAllByRole("USER");
    }
    // update user
    public AppUser updateUser(AppUser appUser , String Role) {
        return appUserRepository.save(appUser);
    }
    //
    public AppUser updateUserRole(AppUser appUser) {
        appUserRepository.save(appUser);
        return appUser;
    }
    // ban a user
    public void banUser(Long id) {
        AppUser appUser = appUserRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        appUser.setBanned(true);
        appUserRepository.save(appUser);
    }
}
