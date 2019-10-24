package com.keshav.hl.springmariaDB.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keshav.hl.springmariaDB.Model.User;
import com.keshav.hl.springmariaDB.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api(value = "UserController", description = "REST Apis related to User!!!!")
@RequestMapping("/user/api")
class UserController {

	
	@Autowired
	UserService userService;
	
	/*@RequestMapping(value="/mariadb/createUser",method = {RequestMethod.GET, RequestMethod.POST}consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createUser(@RequestParam("firstName") String fname,@RequestParam("lastName") String lname ,UriComponentsBuilder ucBuilder){
		
		User user = new User();
		user.setFirstName(fname);
		user.setLastName(lname);
		
		userService.createUser(user);
		HttpHeaders headers = new HttpHeaders();
		
		return new ResponseEntity<>(headers,HttpStatus.CREATED);
		
	}*/
	

	@ApiOperation(value = "Create User")
	@PostMapping(value="/createUser",consumes = "application/json", produces = "application/json")
	public HttpStatus createUser(@RequestBody User user){
		
		User newUser = userService.createUser(user);
		if(!ObjectUtils.isEmpty(newUser)) {
			return HttpStatus.CREATED;
		}		
		return HttpStatus.BAD_REQUEST;
		
	}
	

@ApiOperation(value = "View a list of available Users", response = List.class)
	@GetMapping("/getAllUser")
	public ResponseEntity<List<User>> getAllUser(){
		
		List<User> listOfUser = userService.getUser();
		
		/*List<UserEntity> listOfUserEntity =UserRepository.findAll();
		
		List<User> listOfUser = new ArrayList<>();
		for(UserEntity userEntity:listOfUserEntity) {
			User user = new User();
			BeanUtils.copyProperties(userEntity, user);
			listOfUser.add(user);
		}*/
		
		return new ResponseEntity<List<User>>(listOfUser, HttpStatus.OK);
		
	}
	
	@GetMapping("/hello")
	public ResponseEntity<String> helloUser(){		
		
		return new ResponseEntity<String>("its working",HttpStatus.OK);
		
	}
	
}
