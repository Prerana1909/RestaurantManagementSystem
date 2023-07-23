package com.rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rms.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

}

