package com.group.board.service.board;

import com.group.board.domain.board.RestaurantDto;
import com.group.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    public List<RestaurantDto> getRestaurantList() {
        try {
            return boardMapper.selectRestaurantList();
        } catch (RuntimeException e) {
            return getSampleRestaurants();
        }
    }

    public void addRestaurant(RestaurantDto restaurantDto) {
        boardMapper.insertRestaurant(restaurantDto);
    }

    private List<RestaurantDto> getSampleRestaurants() {
        RestaurantDto first = new RestaurantDto();
        first.setId(1L);
        first.setName("명동교자");
        first.setArea("중구");
        first.setMenu("칼국수");
        first.setMemo("진한 육수와 만두가 유명해요.");

        RestaurantDto second = new RestaurantDto();
        second.setId(2L);
        second.setName("우래옥");
        second.setArea("중구");
        second.setMenu("평양냉면");
        second.setMemo("웨이팅이 길 수 있어요.");

        RestaurantDto third = new RestaurantDto();
        third.setId(3L);
        third.setName("진미평양냉면");
        third.setArea("강남구");
        third.setMenu("어복쟁반");
        third.setMemo("국물 맛이 깔끔해요.");

        return new ArrayList<>(Arrays.asList(first, second, third));
    }
}