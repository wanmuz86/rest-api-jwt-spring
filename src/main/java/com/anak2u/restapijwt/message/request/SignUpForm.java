package com.anak2u.restapijwt.message.request;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class SignUpForm {

	 @NotBlank
	 @Size(min = 3, max = 50)
	 private String name;
	 
	 @NotBlank
	 @Size(min = 3, max = 50)
	 private String username;
	 
	 @NotBlank
	 @Size(max = 60)
	 @Email
	 private String email;
	 
	 @NotBlank
	 @Size(min = 6, max = 40)
	 private String password;
	 
	 private List<String> roles;

}
