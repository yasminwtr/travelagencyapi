package com.api.travelagency.service;

import com.api.travelagency.model.Destination;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DestinationService {
    private List<Destination> destinations = new ArrayList<>();
    private Long nextId = 1L;

    public Destination addDestination(Destination destination) {
        destination.setId(nextId++);
        destinations.add(destination);
        return destination;
    }
    
    public List<Destination> getAllDestinations() {
        return destinations;
    }

    public List<Destination> searchDestinations(String name, String location) {
        return destinations.stream()
                .filter(destination -> (name == null || destination.getName().equalsIgnoreCase(name)) &&
                                       (location == null || destination.getLocation().equalsIgnoreCase(location)))
                .collect(Collectors.toList());
    }

    public Optional<Destination> getDestinationById(Long id) {
        return destinations.stream()
                .filter(destination -> destination.getId().equals(id))
                .findFirst();
    }

    public Optional<Destination> addRatingToDestination(Long id, int rating) {
        Optional<Destination> destination = getDestinationById(id);
        destination.ifPresent(dest -> dest.addRating(rating));
        return destination;
    }

    public boolean deleteDestination(Long id) {
        Optional<Destination> destination = getDestinationById(id);
        if (destination.isPresent()) {
            destinations.remove(destination.get());
            return true;
        }
        return false;
    }
}
