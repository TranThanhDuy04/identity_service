package com.thanhduy.identity_service.service;

import com.thanhduy.identity_service.dto.request.UserCreationRequest;
import com.thanhduy.identity_service.dto.request.UserUpdateRequest;
import com.thanhduy.identity_service.entity.User;
import com.thanhduy.identity_service.repositoy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest userCreationRequest){
        User user = new User();
        user.setUsername(userCreationRequest.getUsername());
        user.setPassword(userCreationRequest.getPassword());
        user.setFirstName(userCreationRequest.getFirstName());
        user.setLastName(userCreationRequest.getLastName());
        user.setDob(userCreationRequest.getDob());

        return userRepository.save(user);
    }

    public User updateUser(String userId, UserUpdateRequest userUpdateRequest){
        User user = getUserById(userId);

        user.setPassword(userUpdateRequest.getPassword());
        user.setFirstName(userUpdateRequest.getFirstName());
        user.setLastName(userUpdateRequest.getLastName());
        user.setDob(userUpdateRequest.getDob());
        return userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUserById(String id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUserById(String id){
        userRepository.deleteById(id);
    }




}
