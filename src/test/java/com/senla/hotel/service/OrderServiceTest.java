package com.senla.hotel.service;

import com.senla.hotel.api.dao.IOrderDao;
import com.senla.hotel.api.service.IOrderService;
import com.senla.hotel.dto.OrderDto;
import com.senla.hotel.exceptions.NoSuchEntityException;
import com.senla.hotel.model.entities.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    private IOrderService orderService;
    @Mock
    private IOrderDao orderDao;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private Order order;
    @Mock
    private OrderDto orderDto;

    private static final Long ID = 1L;

    @BeforeEach
    void setUp() {
        orderService = new OrderService(orderDao, modelMapper);
        order.setId(ID);
        orderDto.setId(ID);
    }

    @Test
    public void whenSaveRoomShouldReturnOrderDto() {
        when(orderDao.save(ArgumentMatchers.any(Order.class))).thenReturn(order);
        when(modelMapper.map(orderDto, Order.class)).thenReturn(order);
        when(modelMapper.map(order, OrderDto.class)).thenReturn(orderDto);
        OrderDto result = orderService.save(orderDto);
        assertEquals(result, orderDto);
        verify(orderDao).save(order);
    }

    @Test
    void getByIdShouldReturnOrderDto() {
        when(orderDao.getById(anyLong())).thenReturn(order);
        when(modelMapper.map(order, OrderDto.class)).thenReturn(orderDto);
        OrderDto result = orderService.getById(anyLong());
        assertEquals(result, orderDto);
        verify(orderDao).getById(anyLong());
    }

    @Test
    void getByIdShouldReturnNull() {
        when(orderDao.getById(anyLong())).thenReturn(null);
        assertThrows(NoSuchEntityException.class, () -> {
            orderService.getById(anyLong());
        });
        verify(orderDao).getById(anyLong());
    }

    @Test
    public void shouldReturnAllOrderFirst() {
        List<Order> orders = new ArrayList();
        orders.add(order);
        List<OrderDto> orderDtos = new ArrayList<>();
        orderDtos.add(orderDto);
        when(modelMapper.map(order, OrderDto.class)).thenReturn(orderDto);
        when(orderDao.getAll()).thenReturn(orders);
        List<OrderDto> expected = orderService.getAll();
        assertEquals(expected, orderDtos);
        verify(orderDao).getAll();
    }

    @Test
    public void shouldReturnExceptInsteadOrders() {
        given(orderDao.getAll()).willThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> {
            orderService.getAll();
        });
        verify(orderDao).getAll();
    }

    @Test
    public void shouldReturnAllOrderSecond() {
        List<Order> orders = new ArrayList();
        orders.add(order);
        given(orderDao.findAll()).willReturn(orders);
        List<Order> expected = orderDao.findAll();
        assertEquals(expected, orders);
        verify(orderDao).findAll();
    }


    @Test
    public void whenGivenOrderShouldDeleteRoomIfFound() {
        orderService.delete(order);
        verify(orderDao).delete(order);
    }

    @Test
    public void whenGivenIdShouldDeleteOrderIfFound() {
        when(orderDao.getById(order.getId())).thenReturn(order);
        orderService.deleteById(order.getId());
        verify(orderDao).deleteById(order.getId());
    }

    @Test
    void shouldThrowExceptionWhenOrderDoesntExist() {
        when(orderDao.getById(anyLong())).thenReturn(null);
        assertThrows(NoSuchEntityException.class, () -> {
            orderService.getById(anyLong());
        });
    }

    @Test
    public void update() {
        when(modelMapper.map(orderDto, Order.class)).thenReturn(order);
        orderService.update(orderDto);
        verify(orderDao).update(order);
    }

}