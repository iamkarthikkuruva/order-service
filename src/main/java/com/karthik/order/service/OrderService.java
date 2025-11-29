package com.karthik.order.service;

import com.karthik.order.dto.OrderDTO;
import com.karthik.order.dto.OrderDTOFromFE;
import com.karthik.order.dto.UserDTO;
import com.karthik.order.entity.Order;
import com.karthik.order.mapper.OrderMapper;
import com.karthik.order.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private SequenceGenerator sequenceGenerator;

    @Autowired
    private RestTemplate restTemplate;

    public OrderDTO saveOrderInDB(OrderDTOFromFE orderDetails) {
        Integer newOrderId = sequenceGenerator.generateNextOrderId();

        UserDTO userDTO = fetchUserDetailsFromUserId(orderDetails.getUserId());
        Order orderToBeSaved = new Order(newOrderId, orderDetails.getFoodItemsList(), orderDetails.getRestaurant(), userDTO);
        orderRepo.save(orderToBeSaved);
        return OrderMapper.INSTANCE.mapOrderToOrderDto(orderToBeSaved);
    }

    private UserDTO fetchUserDetailsFromUserId(Integer userId) {
        return restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById/" + userId, UserDTO.class);
    }
}
