package com.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.bean.Login;
import com.login.service.Service;

@RestController
@CrossOrigin("http://localhost:4200")
public class Controller {
	@Autowired
	private Service service;

	@PostMapping("/userlogins")
	public ResponseEntity<Boolean> userLogin(@RequestBody Login login) throws Exception {
		//output.
		
			Boolean loginRes = service.userLogin(login.getUserName(), login.getPassword());
		System.out.println();
		return new ResponseEntity<>(loginRes, new HttpHeaders(), HttpStatus.OK);
	}

}