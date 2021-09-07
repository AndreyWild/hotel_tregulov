package com.senla.hotel.mappers;

import com.senla.hotel.dto.OrderDto;
import com.senla.hotel.model.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper( OrderMapper.class );

    OrderDto toDTO(Order order);
}
