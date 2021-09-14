package com.senla.hotel.service;

import com.senla.hotel.api.dao.IOrderDao;
import com.senla.hotel.api.service.IOrderService;
import com.senla.hotel.dto.OrderDto;
import com.senla.hotel.exceptions.NoSuchEntityException;
import com.senla.hotel.model.entities.Order;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService implements IOrderService {

    private final IOrderDao orderDao;
    private final ModelMapper modelMapper;

    @Override
    public Order save(Order entity) {
        return orderDao.save(entity);
    }

    @Override
    public OrderDto getById(Long id) {
        Order order = orderDao.getById(id);

        if(order == null){
            throw  new NoSuchEntityException("There is no Order with ID = " + id + " in Database");
        }

        return modelMapper.map(order, OrderDto.class);
    }

    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
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
    public void update(Order entity) {
        orderDao.update(entity);
    }
}
