package com.rms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @Column(length=20, nullable=false)
    private String name;
    
    @Column(length=10,unique = true, nullable = false)
    private String contactDetails;

	public Object getContactDetails() {
		// TODO Auto-generated method stub
		return null;
	}
    
    
    //private int loyaltyPoints;



}
