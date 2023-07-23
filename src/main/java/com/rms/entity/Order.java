package com.rms.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    
    @ManyToMany
    private List<Menu> menu;
    
    @Column(length=20,nullable = false)
    private int quantity;
    
    @ManyToOne
    private Customer customer;
    
  
    private String status;

}
