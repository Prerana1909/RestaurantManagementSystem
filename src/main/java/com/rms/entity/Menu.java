package com.rms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuId;
    
    @Column(length=20, unique = true, nullable= false)
    private String name;

    @Column(length = 50, nullable = false)
    private String description;

    @Column(length = 20, nullable = false)
    private double price;

    @OneToMany//one menu belongs to multiple order
    private Order order;
  

}
