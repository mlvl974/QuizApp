package com.ncs.admin.exception;

import java.time.LocalDateTime;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AllExceptionHandler 
{
	
	
	public AllExceptionHandler() {
		System.out.println("--->> Inside Controller Advice ");
	}

	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handleIllegalArgumentExceptionTemplateData(IllegalArgumentException e)
	{
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getMessage());
		template.setUserInput("");
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handleNoSuchElementExceptionTemplateData(java.util.NoSuchElementException e)
	{
		System.out.println("--->> Inside Exeption Handler : NoSuchElement ");
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getMessage());
		template.setUserInput("");
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	

	
	
	
	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handleNullPointerExceptionTemplateData(NullPointerException e)
	{
		System.out.println("--->> Inside Exeption Handler : NullPointerException ");
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getMessage());
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handleInvalidUserRoleTemplateData(InvalidUserRoleException e)
	{
		System.out.println("--->> Inside Exeption Handler : User Role invalid ");
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg("Invalid Role");
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handleInvalidDateRangeTemplateData(InvalidDateRangeException e)
	{
		System.out.println("--->> Inside Exeption Handler : Date Range invalid ");
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg("Invalid Date Range");
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handleUserNotFoundTemplateData(UserNotFoundException e)
	{
		System.out.println("--->> Inside Exeption Handler : User Id Not Found");
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg("User id Not Found.");
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handleUserDuplicateTemplateData(DuplicateUserException e)
	{
		System.out.println("--->> Inside Exeption Handler : Duplicate User Found");
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg("Duplicate user found.");
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handleInvalidCategoryTemplateData(InvalidCategoryException e)
	{
		System.out.println("--->> Inside Exeption Handler : Category is invalid");
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg("Category is invalid.");
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	

}
