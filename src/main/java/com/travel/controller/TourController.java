package com.travel.controller;

import com.travel.model.Tour;
import com.travel.service.TourService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tours")
@CrossOrigin(origins = "http://localhost:3000")
public class TourController {
    @Autowired
    private TourService tourService;

    @Operation(summary = "Get all tours", description = "Retrieve a list of all available tours")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of tours"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public List<Tour> getAllTours() {
        return tourService.getAllTours();
    }

    @Operation(summary = "Add a new tour", description = "Create a new tour with the provided details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tour created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public Tour addTour(@RequestBody Tour tour) {
        return tourService.addTour(tour);
    }
}