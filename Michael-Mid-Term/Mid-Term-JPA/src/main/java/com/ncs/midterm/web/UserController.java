package com.ncs.midterm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.midterm.exception.InvalidPincodeException;
import com.ncs.midterm.model.MySecuredUsers;
import com.ncs.midterm.service.AppUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	AppUserService appUserService;

	@GetMapping("/{id}")
	public ResponseEntity<MySecuredUsers> viewProfile(@PathVariable int id) {
		MySecuredUsers user = appUserService.viewProfile(id);

		return new ResponseEntity<MySecuredUsers>(user, HttpStatus.OK);

	}

	@PutMapping("/{id}/pincode")
	public ResponseEntity<MySecuredUsers> updatePincode(@PathVariable int id, @RequestParam long pincode) throws InvalidPincodeException

	{
		MySecuredUsers user = appUserService.updatePincode(id, pincode);

		return new ResponseEntity<MySecuredUsers>(user, HttpStatus.OK);

	}

}// end of class
