package com.karthik.order.mapper;

import com.karthik.order.dto.OrderDTO;
import com.karthik.order.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order  mapOrderDtoToOder(OrderDTO orderDTO);
    OrderDTO mapOrderToOrderDto(Order order);
}
