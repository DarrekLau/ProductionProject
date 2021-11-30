package com.example.finalproject2.repository;

import com.example.finalproject2.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = "select * from booking b " +
            "where b.full_name like %:keyword% or b.email like %:keyword% " +
            "or b.health_Medical_Package like %:keyword% " +
            "or b.rest_Relaxation_Package like %:keyword% " +
            "or b.diet_Nutrition_Package like %:keyword%"
            , nativeQuery = true)
    List<Booking> findByKeyword(@Param("keyword") String keyword);
}
