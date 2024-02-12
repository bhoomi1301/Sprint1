package com.spring.tatms.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.spring.tatms.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking,Integer> {

}
