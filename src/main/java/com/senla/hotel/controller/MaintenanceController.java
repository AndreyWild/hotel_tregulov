package com.senla.hotel.controller;

import com.senla.hotel.api.service.IMaintenanceService;
import com.senla.hotel.dto.MaintenanceDto;
import com.senla.hotel.model.entities.Maintenance;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Log4j
@RestController
@RequestMapping("/maintenances")
@RequiredArgsConstructor
public class MaintenanceController {

    private final IMaintenanceService maintenanceService;

    @GetMapping
    public List<MaintenanceDto> getAll() {
        log.info("Received request (GET): /maintenances");
        return maintenanceService.getAll().stream().map(MaintenanceDto::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MaintenanceDto getById(@PathVariable Long id) {
        log.info("Received request (GET): /maintenances/" + id);
        return new MaintenanceDto(maintenanceService.getById(id));
    }

    @PostMapping
    public MaintenanceDto save(@RequestBody MaintenanceDto maintenanceDto) {
        log.info("Received request (POST): /maintenances");
        Maintenance maintenance = new Maintenance();
        maintenance.setName(maintenanceDto.getName());
        maintenance.setPrice(maintenanceDto.getPrice());
        return new MaintenanceDto(maintenanceService.save(maintenance));
    }

    @PutMapping
    public MaintenanceDto update(@RequestBody MaintenanceDto maintenanceDto) {
        log.info("Received request (PUT): /maintenances");
        Maintenance maintenance = new Maintenance();
        maintenance.setId(maintenanceDto.getId());
        maintenance.setName(maintenanceDto.getName());
        maintenance.setPrice(maintenanceDto.getPrice());
        maintenanceService.update(maintenance);
        return maintenanceDto;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        log.info("Received request (DELETE): /maintenances/" + id);
        maintenanceService.deleteById(id);
        return "Maintenance with ID = " + id + " was deleted";
    }
}
