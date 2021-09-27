package com.senla.hotel.service;

import com.senla.hotel.api.dao.IOrderDao;
import com.senla.hotel.api.service.IOrderService;
import com.senla.hotel.dto.OrderDto;
import com.senla.hotel.exceptions.NoSuchEntityException;
import com.senla.hotel.model.entities.Order;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService implements IOrderService {

    private final IOrderDao orderDao;
    private final ModelMapper modelMapper;

    @Override
    public OrderDto save(OrderDto entity) {
        Order order = orderDao.save(modelMapper.map(entity, Order.class));
        return modelMapper.map(order, OrderDto.class);
    }

    @Override
    public OrderDto getById(Long id) {
        Order order = orderDao.getById(id);

        if (order == null) {
            throw new NoSuchEntityException("There is no Order with ID = " + id + " in Database");
        }

        return modelMapper.map(order, OrderDto.class);
    }

    @Override
    public List<OrderDto> getAll() {
        return orderDao.getAll().stream().map(order -> modelMapper.map(order, OrderDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Override
    public void delete(Order entity) {
        orderDao.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        Order order = orderDao.getById(id);
        if (order == null) {
            throw new NoSuchEntityException("There is no order with ID = "
                    + id + " in Database");
        }
        orderDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        orderDao.deleteAll();
    }

    @Override
    public void update(OrderDto entity) {
        orderDao.update(modelMapper.map(entity, Order.class));
    }

    @Override
    public List<OrderDto> getSortedListByField(String fieldName) {
        return orderDao.getSortedListByField(fieldName).stream()
                .map(room -> modelMapper.map(room, OrderDto.class)).collect(Collectors.toList());
    }
}
