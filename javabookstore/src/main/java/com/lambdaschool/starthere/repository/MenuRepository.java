package com.lambdaschool.starthere.repository;


import com.lambdaschool.starthere.models.Menu;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<Menu, Long>
{
}
