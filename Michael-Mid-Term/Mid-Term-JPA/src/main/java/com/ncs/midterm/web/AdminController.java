package com.ncs.midterm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.midterm.exception.InvalidAgeException;
import com.ncs.midterm.exception.InvalidPincodeException;
import com.ncs.midterm.exception.InvalidUserRoleException;
import com.ncs.midterm.model.MySecuredUsers;
import com.ncs.midterm.service.AppUserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AppUserService appUserService;
	
	@PostMapping("/saveusers")
	public MySecuredUsers addUsers(@RequestBody MySecuredUsers mySecuredUsers) throws InvalidAgeException,InvalidUserRoleException {
		return appUserService.saveUsers(mySecuredUsers);
	}

	@GetMapping("/users")
	public ResponseEntity<List<MySecuredUsers>> getAllUsers()
	{
		List<MySecuredUsers> userList = appUserService.getAllUsers();
		
		return new ResponseEntity<List<MySecuredUsers>>(userList,HttpStatus.OK);
	}

	@GetMapping ("/users/{pincode}")
	public ResponseEntity<MySecuredUsers> getUsersPincode(@PathVariable long pincode ) throws InvalidPincodeException

	{
		MySecuredUsers user = appUserService.getUserByPincode(pincode);
		if(user != null)
		{
			return new ResponseEntity<MySecuredUsers>(user,HttpStatus.OK);
		}
		else {
			throw new InvalidPincodeException ("Invalid Pincode!",pincode);
		}
		
		// return appUserService.getUserByPincode(pincode);
	}

}// end class
