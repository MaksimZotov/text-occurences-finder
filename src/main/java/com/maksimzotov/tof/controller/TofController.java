package com.maksimzotov.tof.controller;

import com.maksimzotov.tof.model.FindOccurrencesRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TofController {

    @PostMapping("/find/")
    public ResponseEntity<?> find(@RequestBody FindOccurrencesRequest request) {
        return null;
    }
}
