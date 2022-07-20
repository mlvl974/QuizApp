package com.ncs.midterm.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.midterm.dto.AppUserRequestDTO;
import com.ncs.midterm.dto.JWTResponseDTO;
import com.ncs.midterm.exception.InvalidAgeException;
import com.ncs.midterm.exception.InvalidPincodeException;
import com.ncs.midterm.exception.InvalidUserRoleException;
import com.ncs.midterm.jwtutil.JWTUtil;
import com.ncs.midterm.model.MySecuredUsers;
import com.ncs.midterm.service.AppUserServiceImpl;

@RestController
@RequestMapping("/public")
public class PublicController {

	@Autowired
	private AppUserServiceImpl appUserServiceImpl;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@PostMapping("/login")
	public ResponseEntity<JWTResponseDTO> doLogin(@RequestBody AppUserRequestDTO userEntry)throws Exception
	{
		System.out.println("----->> inside public/login "+userEntry);
		
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userEntry.getUsername(), userEntry.getPassword()));
			System.out.println();
			
		} catch (Exception e) {
			throw new Exception("Bad credentials ");
		}

		UserDetails userDetails =  appUserServiceImpl.loadUserByUsername(userEntry.getUsername());
		
		String token = jwtUtil.generateToken(userDetails);
		
		boolean isValid = token!=null?true:false;
		
		JWTResponseDTO jwtResponseDTO = new JWTResponseDTO(token, userEntry.getUsername(), isValid);
		
		return new ResponseEntity<JWTResponseDTO>(jwtResponseDTO, HttpStatus.OK);
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<MySecuredUsers> addUser (@Valid @RequestBody MySecuredUsers appUsers) throws InvalidAgeException,InvalidUserRoleException 
	{
		MySecuredUsers user = appUserServiceImpl.saveUsers(appUsers);
		
		return new ResponseEntity<MySecuredUsers>(user,HttpStatus.OK);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}// end of class 
