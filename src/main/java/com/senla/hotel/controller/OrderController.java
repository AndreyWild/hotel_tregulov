package com.senla.hotel.controller;

import com.senla.hotel.api.service.IOrderService;
import com.senla.hotel.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.*;


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
}
