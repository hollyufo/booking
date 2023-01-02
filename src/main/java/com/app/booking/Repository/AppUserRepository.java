package com.app.booking.Repository;


import com.app.booking.Entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByEmail(String email);

    // list all the managers
    List<AppUser> findAllByRole(String role);
    // update the role of a user
    AppUser findByRole(String role);

    List<AppUser> findAllByisBanned(boolean b);
}
