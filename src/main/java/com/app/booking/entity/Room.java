package com.app.booking.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Room")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Room  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomId", nullable = false)
    private Long id;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "roomNumber")
    private int roomNumber;

    @Column(name = "type")
    private String type;


    @Column(name = "price")
    private double price;


    @ManyToOne
    private Hotel hotel;

    @OneToMany(mappedBy = "room",fetch = FetchType.EAGER)
    private List<Reservation> listReservation;

}