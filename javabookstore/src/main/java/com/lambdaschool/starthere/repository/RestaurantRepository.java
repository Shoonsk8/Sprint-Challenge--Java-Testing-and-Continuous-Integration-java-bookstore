package com.lambdaschool.starthere.repository;


import com.lambdaschool.starthere.models.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long>
{
    Restaurant findByName(String name);
}
