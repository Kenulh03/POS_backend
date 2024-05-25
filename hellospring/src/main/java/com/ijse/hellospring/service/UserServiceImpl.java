package com.ijse.hellospring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ijse.hellospring.entity.User;
import com.ijse.hellospring.repository.UserRepository;
import com.ijse.hellospring.dto.CustomUserDetails;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public CustomUserDetails findUserByUsername(String username) throws UsernameNotFoundException {
       
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found with the given email");
        }
        return new CustomUserDetails(user);
    }

    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public String getRoleByUsername(String username) {
        User user = userRepository.findByUsername(username);
        
        if (user == null) {
            throw new UsernameNotFoundException("No user found with the given email");
        }

        return user.getRole();
    }

    @Override
    public User updateUser(Long id,User user){
        User existUser = userRepository.findById(id).orElse(null);

        if(existUser!=null) {
            existUser.setUsername(user.getUsername());
            existUser.setEmail(user.getEmail());
            existUser.setPassword(user.getPassword());
            existUser.setRole(user.getRole());
            return userRepository.save(existUser);
        }else{
            return null;
        }
    }

    @Override
    public  void deleteUser(Long id){
        userRepository.deleteById(id);
    }

}
