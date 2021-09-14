package com.senla.hotel.controller;

import com.senla.hotel.api.service.IOrderService;
import com.senla.hotel.dto.OrderDto;
import com.senla.hotel.model.entities.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Log4j
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final IOrderService orderService;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<OrderDto> getAll(){
        log.info("Received request (GET): /orders");
        return orderService.getAll().stream().map(OrderDto::new).collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public OrderDto getById(@PathVariable Long id){
        log.info("Received request (GET): /orders/" + id);
        return orderService.getById(id);
    }

    @PostMapping
    public Order save(@RequestBody Order order) {
        log.info("Received request (POST): /orders");
        orderService.save(order);
        return order;
    }

    @PutMapping
    public Order update(@RequestBody Order order) {
        log.info("Received request (PUT): /orders");
        orderService.update(order);
        return order;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        log.info("Received request (DELETE): /orders/" + id);
        orderService.deleteById(id);
        return "Order with ID = " + id + " was deleted";
    }
}
