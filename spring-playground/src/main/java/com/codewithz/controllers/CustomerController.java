package com.codewithz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codewithz.config.ApiSuccessPayload;
import com.codewithz.model.Customer;
import com.codewithz.services.CustomerService;

import javax.validation.Valid;


@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	
	public CustomerController(CustomerService customerService) {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/{customerId}")
	public ResponseEntity<ApiSuccessPayload> getCustomer(@PathVariable Long customerId,@RequestParam String category) {
		System.out.println(category);
		Customer c=customerService.getCustomerById(customerId);
		HttpStatus status=HttpStatus.OK;
		ApiSuccessPayload payload=ApiSuccessPayload.build(c,"Customer Found",status);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<>(payload,status);
		return response;
	}
	
	@GetMapping
	public ResponseEntity<ApiSuccessPayload> getCustomers(){
		List<Customer> list=customerService.getCustomers();
		HttpStatus status=HttpStatus.OK;
		ApiSuccessPayload payload=ApiSuccessPayload.build(list,"Customers List Found",status);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<>(payload,status);
		return response;

	}

	@PostMapping
	public ResponseEntity<ApiSuccessPayload> addCustomer(@Valid  @RequestBody Customer customer){
		HttpStatus status=HttpStatus.CREATED;
		ApiSuccessPayload payload=ApiSuccessPayload.build("OK","OK",status);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<>(payload,status);
		return response;

	}


	
	
}
