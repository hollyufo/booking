package com.app.booking.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Date startDate;
        private Date endDate;
        // client

        @ManyToOne
        @JoinColumn(name = "client_id")
        private AppUser client;
        private int price;
        private int capacity;

        // room
        @ManyToOne
        @JoinColumn(name = "room_id")
        private Room room;

        // Status
        @Enumerated(EnumType.STRING)
        private ReservationStatus reservationStatus;
}
