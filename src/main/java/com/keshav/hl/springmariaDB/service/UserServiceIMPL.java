package com.keshav.hl.springmariaDB.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keshav.hl.springmariaDB.Entity.AddressEntity;
import com.keshav.hl.springmariaDB.Entity.UserEntity;
import com.keshav.hl.springmariaDB.Model.AddressDTO;
import com.keshav.hl.springmariaDB.Model.User;
import com.keshav.hl.springmariaDB.Repository.UserRepository;

@Service
public class UserServiceIMPL implements UserService {
	
	 
	@Autowired
	UserRepository userRepository;
	
	List<AddressDTO> listofAddress = null;
	List<AddressEntity> listOfAddressEntity =  null;

	@Override
	public User createUser(User user) {
		UserEntity userEntity = new UserEntity();
		 listofAddress = user.getListOfAddress();
		 listOfAddressEntity =  new ArrayList<>();
		 BeanUtils.copyProperties(user, userEntity);
		 for(AddressDTO addressDTO:listofAddress) {
			 AddressEntity addressEntity = new AddressEntity();
			 BeanUtils.copyProperties(addressDTO, addressEntity);
			 addressEntity.setAddressID(UUID.randomUUID());
			 listOfAddressEntity.add(addressEntity);			 
		 }
		 userEntity.setId(UUID.randomUUID());
		 userEntity.setListOfAddress(listOfAddressEntity);
		 userEntity.setCreatedOn(new Date());
		 userEntity.setRowStatus(1);
		userEntity = userRepository.save(userEntity);
		User newUser = new User();
		BeanUtils.copyProperties(userEntity, newUser);
		return newUser;
	}

	@Override
	public List<User> getUser() {
		List<UserEntity> listOfUserEntity = userRepository.findAll();
		List<User> listOfUser = new ArrayList<>();
		for(UserEntity userEntity:listOfUserEntity) {
			User user = new User();
			BeanUtils.copyProperties(userEntity, user);
			listOfUser.add(user);
		}
		return listOfUser;
	}

	@Override
	public User findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User user, long l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User updatePartially(User user, long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
