package com.api.travelagency.controller;

import com.api.travelagency.model.Destination;
import com.api.travelagency.service.DestinationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/destinations")
public class DestinationController {
    private final DestinationService destinationService = new DestinationService();

    @PostMapping
    public ResponseEntity<Destination> addDestination(@RequestBody Destination destination) {
        Destination savedDestination = destinationService.addDestination(destination);
        return ResponseEntity.status(201).body(savedDestination);
    }

    @GetMapping
    public ResponseEntity<List<Destination>> getAllDestinations() {
        List<Destination> destinations = destinationService.getAllDestinations();
        return ResponseEntity.ok(destinations);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Destination>> searchDestinations(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String location) {

        List<Destination> results = destinationService.searchDestinations(name, location);
        return ResponseEntity.ok(results);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destination> getDestinationById(@PathVariable Long id) {
        Optional<Destination> destination = destinationService.getDestinationById(id);
        return destination.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/rate")
    public ResponseEntity<Destination> addRating(
            @PathVariable Long id,
            @RequestParam int rating) {

        if (rating < 1 || rating > 10) {
            return ResponseEntity.badRequest().body(null);
        }

        Optional<Destination> updatedDestination = destinationService.addRatingToDestination(id, rating);
        return updatedDestination.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDestination(@PathVariable Long id) {
        boolean isDeleted = destinationService.deleteDestination(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();  
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
