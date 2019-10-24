package com.keshav.hl.springmariaDB.Model;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
	
	private String firstName;
	private String lastName;
	private String email;
	private Long mobile;	    
	private List<AddressDTO> listOfAddress;
	

}
