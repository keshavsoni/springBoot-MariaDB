package com.keshav.hl.springmariaDB.service;

import java.util.List;

import com.keshav.hl.springmariaDB.Model.User;

public interface UserService {
	
	public User createUser(User user);
    public List<User> getUser();
    public User findById(long id);
    public User update(User user, long l);
    public void deleteUserById(long id);
    public User updatePartially(User user, long id);

}
