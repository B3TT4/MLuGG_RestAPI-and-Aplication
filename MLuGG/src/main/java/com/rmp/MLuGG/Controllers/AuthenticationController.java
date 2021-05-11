package com.rmp.MLuGG.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.rmp.MLuGG.Details.CustomUserDetails;
import com.rmp.MLuGG.Services.CustomUserDetailsService;



import io.swagger.annotations.Api;

@Api(value = "Swagger2RestController", description = "REST API")
@RestController
@RequestMapping("/Login")
public class AuthenticationController {
	
	@Autowired
	private CustomUserDetailsService userDetailsService;

	
}
