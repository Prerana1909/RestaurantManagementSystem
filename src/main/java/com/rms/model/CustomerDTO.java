package com.rms.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CustomerDTO {

	 private Long customerId;

	 @NotNull(message="Name cannot be null")
	 @NotBlank(message="Name is required")
	 private String name;
	    
	 @NotNull(message="Phone number cannot be null")
	 @NotBlank(message="Phone number is required")
	 @Pattern(regexp="[6789]{1}[0-9]{9}$",message="phone number should consist of 10 digits")
	 private String contactDetails;
	    
}
