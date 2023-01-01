package com.app.booking.Repository;


import com.app.booking.Entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByEmail(String email);

    // list all the managers
    List<AppUser> findAllByRole(String role);
    // update the role of a user
    AppUser findByRole(String role);

}
