package com.spring.tatms.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.spring.tatms.entity.Destination;

public interface DestinationRepository extends JpaRepository<Destination,Integer> {

}
