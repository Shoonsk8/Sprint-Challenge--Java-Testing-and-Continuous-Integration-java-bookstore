package com.lambdaschool.starthere.repository;


import com.lambdaschool.starthere.models.Payment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PaymentRepository extends CrudRepository<Payment, Long>
{
    @Transactional
    @Modifying
    @Query(value = "DELETE from RestaurantPayments where restaurantid = :restaurantid")
    void deleteRestaurantPaymentsbyRestaurantId(long restaurantid);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO RestaurantPayments(restaurantid, paymentid) values (:restaurantid, :paymentid)", nativeQuery = true)
    void insertIntoRestaurantPayments(long restaurantid, long paymentid);
}
