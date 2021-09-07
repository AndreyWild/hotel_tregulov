package com.senla.hotel.controller;

import com.senla.hotel.api.service.IMaintenanceService;
import com.senla.hotel.exceptions.NoSuchEntityException;
import com.senla.hotel.model.entities.Maintenance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maintenances")
public class MaintenanceController {

    @Autowired
    IMaintenanceService maintenanceService;

    @GetMapping("/maintenances")
    public List<Maintenance> getAll(){
        List<Maintenance> allMaintenance = maintenanceService.getAll();
        return allMaintenance;
    }

    @GetMapping("/maintenances/{id}")
    public Maintenance getById(@PathVariable Long id){
        Maintenance room = maintenanceService.getById(id);

        if(room == null){
            throw  new NoSuchEntityException("There is no Maintenance with ID = " + id + " in Database");
        }

        return room;
    }

    @PostMapping("/maintenances")
    public Maintenance save(@RequestBody Maintenance maintenance) {
        maintenanceService.save(maintenance);
        return maintenance;
    }

    @PutMapping("/maintenances")
    public Maintenance update(@RequestBody Maintenance maintenance) {
        maintenanceService.update(maintenance);
        return maintenance;
    }

    @DeleteMapping("/maintenances/{id}")
    public String delete(@PathVariable Long id) {
        Maintenance maintenance = maintenanceService.getById(id);
        if (maintenance == null) {
            throw new NoSuchEntityException("There is no maintenance with ID = "
                    + id + " in Database");
        }

        maintenanceService.deleteById(id);
        return "Maintenance with ID = " + id + " was deleted";
    }
}
