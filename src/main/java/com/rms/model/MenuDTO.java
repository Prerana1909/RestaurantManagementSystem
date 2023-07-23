package com.rms.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuDTO {

    private Long menuId;
    
    @NotNull(message="Name cannot be null")
	@NotBlank(message="Name is required")
    private String name;

    @NotNull(message="Enter description")
    @Size(max=30,message="Maximum 30 characters allowed")
    @Size(min=10,message="Minimum 10 characters required")
    private String description;

    @NotNull(message="Price cannot be null")
	@NotBlank(message="Price is required")
    private double price;
}
