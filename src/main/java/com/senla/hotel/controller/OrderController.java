package com.senla.hotel.controller;


import com.senla.hotel.api.service.IOrderService;
import com.senla.hotel.dto.OrderDto;
import com.senla.hotel.exceptions.NoSuchEntityException;
import com.senla.hotel.mappers.OrderMapper;
import com.senla.hotel.model.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    IOrderService orderService;

    @GetMapping("/orders")
    public List<Order> getAll(){
        List<Order> allOrders = orderService.getAll();
        return allOrders;
    }

    @GetMapping("/orders/{id}")
    public OrderDto getById(@PathVariable Long id){
        Order order = orderService.getById(id);

        if(order == null){
            throw  new NoSuchEntityException("There is no Order with ID = " + id + " in Database");
        }

        return new OrderDto(order);
    }

    @PostMapping("/orders")
    public Order save(@RequestBody Order order) {
        orderService.save(order);
        return order;
    }

    @PutMapping("/orders")
    public Order update(@RequestBody Order order) {
        orderService.update(order);
        return order;
    }

    @DeleteMapping("/orders/{id}")
    public String delete(@PathVariable Long id) {
        Order order = orderService.getById(id);
        if (order == null) {
            throw new NoSuchEntityException("There is no order with ID = "
                    + id + " in Database");
        }

        orderService.deleteById(id);
        return "Order with ID = " + id + " was deleted";
    }

}
