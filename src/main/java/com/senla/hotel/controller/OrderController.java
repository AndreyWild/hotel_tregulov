package com.senla.hotel.controller;

import com.senla.hotel.api.controller.IOrderController;
import com.senla.hotel.api.service.IOrderService;
import com.senla.hotel.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController extends AbstractController<OrderDto, IOrderService> /*implements IOrderController*/ {

    private static final String ENDPOINT = "orders";

    @Override
    protected String getEndPoint() {
        return ENDPOINT;
    }

//    private final IOrderService orderService;
//
//    @GetMapping
//    public List<OrderDto> getAll() {
//        log.info("Received request (GET): /orders");
//        return orderService.getAll();
//    }
//
//    @GetMapping("/{id}")
//    public OrderDto getById(@PathVariable Long id) {
//        log.info("Received request (GET): /orders/" + id);
//        return orderService.getById(id);
//    }
//
//    @PostMapping
//    public OrderDto save(@RequestBody OrderDto orderDto) {
//        log.info("Received request (POST): /orders");
//        return orderService.save(orderDto);
//    }
//
//    @PutMapping
//    public OrderDto update(@RequestBody OrderDto orderDto) {
//        log.info("Received request (PUT): /orders");
//        orderService.update(orderDto);
//        return orderDto;
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable Long id) {
//        log.info("Received request (DELETE): /orders/" + id);
//        orderService.deleteById(id);
//        return "Order with ID = " + id + " was deleted";
//    }
}
