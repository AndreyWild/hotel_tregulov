package com.senla.hotel.dao;

import com.senla.hotel.api.dao.IOrderDao;
import com.senla.hotel.model.entities.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao extends AbstractDao<Order> implements IOrderDao {

    @Override
    Class<Order> getGenericClass() {
        return Order.class;
    }
}
