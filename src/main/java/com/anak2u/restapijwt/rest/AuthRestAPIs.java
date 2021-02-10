package com.anak2u.restapijwt.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anak2u.restapijwt.entity.User;
import com.anak2u.restapijwt.message.request.LoginForm;
import com.anak2u.restapijwt.message.request.SignUpForm;
import com.anak2u.restapijwt.repository.RoleRepository;
import com.anak2u.restapijwt.repository.UserRepository;
import com.anak2u.restapijwt.security.jwt.JwtProvider;

@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

	@Autowired
    AuthenticationManager authenticationManager;
	
	@Autowired
    PasswordEncoder encoder;
	
	 @Autowired
	 RoleRepository roleRepository;
	 
	 @Autowired
	 UserRepository userRepository;
	 
	 @Autowired
	 JwtProvider jwtProvider;
	 
	 @PostMapping("/register")
	 public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm 
			 signUpRequest){
		 User user = new User(signUpRequest.getName(), 
				 signUpRequest.getUsername(), 
				 encoder.encode(signUpRequest.getPassword()));
		 userRepository.save(user);
		 return ResponseEntity.ok("User registered succesfully!");
	 }
	 
	 @PostMapping("/signin")
	    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
	 
	        Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        loginRequest.getUsername(),
	                        loginRequest.getPassword()
	                )
	        );
	 
	        SecurityContextHolder.getContext().setAuthentication(authentication);

	        String jwt = jwtProvider.generateJwtToken(authentication);
	        return ResponseEntity.ok(jwt);
	    }
	 
	 
}
