package com.ijse.hellospring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.hellospring.entity.User;

@Service
public interface UserService {
   List<User> getAllUsers();
   User getUserById(Long id);
   User createUser(User user);
   User updateUser(Long id,User user);
   void deleteUser(Long id);
}
