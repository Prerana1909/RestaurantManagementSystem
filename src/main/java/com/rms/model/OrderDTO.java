package com.rms.model;

import java.util.List;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.rms.entity.Customer;
import com.rms.entity.Menu;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class OrderDTO {
	
    private Long orderId;
    
    @ManyToMany
    private List<Menu> menu;
    
    @NotNull(message="Quantity cannot be null")
	@NotBlank(message="Quantity is required")
    @Size(max=50,message="Maximum quantity is 50")
    @Size(min=2,message="Minimum quantity is 2")
    private int quantity;
    
    @ManyToOne
    private Customer customer;
    
    private String status;

}
