package com.app.booking.Controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class testController {

        @GetMapping("/testing")
        public ResponseEntity<String> test() {
            return ResponseEntity.ok("test fuck yes");
        }
}
