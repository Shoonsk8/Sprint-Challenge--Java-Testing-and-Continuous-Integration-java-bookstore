package com.lambdaschool.starthere.services;


import com.lambdaschool.starthere.models.Restaurant;

import java.util.List;

public interface RestaurantService
{
    List<Restaurant> findAll();

    Restaurant findRestaurantById(long id);

    Restaurant findRestaurantByName(String name);

    void delete(long id);

    Restaurant save(Restaurant restaurant);

    Restaurant update(Restaurant restaurant, long id);
}
