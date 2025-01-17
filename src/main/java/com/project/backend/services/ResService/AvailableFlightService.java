package com.project.backend.services.ResService;

import com.project.backend.models.ResponseModel.AvailableFlight;
import com.project.backend.repositories.ResRepo.AvailableFlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvailableFlightService {

    @Autowired
    private AvailableFlightRepo repository;

    public List<AvailableFlight> getAvailable(String from, String to, LocalDate date){
        if(date.isBefore(LocalDate.now())) throw new IllegalArgumentException("Invalid date");
        List<AvailableFlight> data = repository.findAll().stream()
                                        .filter(flight -> date.isEqual(flight.getFlightDate().toLocalDate()))
                                        .filter(flight -> flight.getFrom().equals(from))
                                        .filter(flight -> flight.getTo().equals(to))
                                        .collect(Collectors.toList());
        return data;

    }

}
