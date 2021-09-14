package com.senla.hotel.controller;

import com.senla.hotel.api.service.IMaintenanceService;
import com.senla.hotel.dto.MaintenanceDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j
@RestController
@RequestMapping("/maintenances")
@RequiredArgsConstructor
public class MaintenanceController {

    private final IMaintenanceService maintenanceService;

    @GetMapping
    public List<MaintenanceDto> getAll() {
        log.info("Received request (GET): /maintenances");
        return maintenanceService.getAll();
    }

    @GetMapping("/{id}")
    public MaintenanceDto getById(@PathVariable Long id) {
        log.info("Received request (GET): /maintenances/" + id);
        return maintenanceService.getById(id);
    }

    @PostMapping
    public MaintenanceDto save(@RequestBody MaintenanceDto maintenanceDto) {
        log.info("Received request (POST): /maintenances");
        return maintenanceService.save(maintenanceDto);
    }

    @PutMapping
    public MaintenanceDto update(@RequestBody MaintenanceDto maintenanceDto) {
        log.info("Received request (PUT): /maintenances");
        maintenanceService.update(maintenanceDto);
        return maintenanceDto;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        log.info("Received request (DELETE): /maintenances/" + id);
        maintenanceService.deleteById(id);
        return "Maintenance with ID = " + id + " was deleted";
    }
}
