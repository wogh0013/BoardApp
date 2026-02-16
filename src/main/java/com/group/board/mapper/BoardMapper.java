package com.group.board.mapper;

import com.group.board.domain.board.RestaurantDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<RestaurantDto> selectRestaurantList();

    void insertRestaurant(RestaurantDto restaurantDto);
}