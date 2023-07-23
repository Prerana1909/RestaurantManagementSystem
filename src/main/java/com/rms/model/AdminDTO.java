package com.rms.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AdminDTO {
	
    
	private Long adminId;

	@NotNull(message="Name cannot be null")
	@NotBlank(message="Name is required")
    private String name;
    
	@NotNull(message="Email cannot be null")
	@NotBlank(message="Email is required")
	@Email(message="Enter valid email id")
    private String email;
}
