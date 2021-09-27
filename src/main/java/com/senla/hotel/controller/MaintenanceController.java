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
public class MaintenanceController extends AbstractController<MaintenanceDto, IMaintenanceService> /*implements IMaintenanceController*/ {

    private static final String ENDPOINT = "maintenances";

    @Override
    protected String getEndPoint() {
        return ENDPOINT;
    }

    private final IMaintenanceService maintenanceService;

    @GetMapping("/sorted/name_v2")
    public List<MaintenanceDto> getAllSortedByName() {
        log.info("Received request (GET): /maintenances/sorted/name");
        return maintenanceService.getSortedListByField("name");
    }

    @GetMapping("/sorted/price_v2")
    public List<MaintenanceDto> getAllSortedByPrice() {
        log.info("Received request (GET): /maintenances/sorted/price");
        return maintenanceService.getSortedListByField("price");
    }
}
