package com.app.booking.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class hotelVo {
    private String address;
    private String city;
    private String image;

    private String name;

}
