package com.karthik.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTOFromFE {
    private Integer userId;
    private List<FoodItemDTO> foodItemsList;
    private Restaurant restaurant;
}
