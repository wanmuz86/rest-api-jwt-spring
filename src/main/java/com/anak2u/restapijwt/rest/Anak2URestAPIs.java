package com.anak2u.restapijwt.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Anak2URestAPIs {

	 @GetMapping("/api/test/user")
	  public String userAccess() {
	    return ">>> User Contents!";
	  }
}
	  
	
