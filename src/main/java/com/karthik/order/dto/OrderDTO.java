package com.karthik.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Integer userId;
    private List<FoodItemDTO> foodItemDTOList;
    private Restaurant restaurant;
    private UserDTO userDTO;
}
