package com.ncs.login.web;

import javax.validation.Valid;



import org.apache.tomcat.util.net.openssl.ciphers.Authentication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.login.dto.AppUserRequestDTO;
import com.ncs.login.dto.JWTResponseDTO;
import com.ncs.login.jwtutil.JWTUtil;
import com.ncs.login.exception.DuplicateUserException;
import com.ncs.login.exception.InvalidUserRoleException;
import com.ncs.login.model.User;





@RestController
@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:4200"},allowedHeaders = "*")
@RequestMapping("/abc-university/public")
public class PublicController {

	@Autowired
	private com.ncs.login.service.AppUserServiceImpl appUserServiceImpl;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public ResponseEntity<com.ncs.login.dto.JWTResponseDTO> doLogin(@RequestBody AppUserRequestDTO userEntry)throws Exception
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
	public ResponseEntity<User> addUser (@Valid @RequestBody User appUsers)  throws DuplicateUserException
	{
		User user = appUserServiceImpl.saveUsers(appUsers);
		
		return new ResponseEntity<User>(user,HttpStatus.OK);
		
		
	}
}
