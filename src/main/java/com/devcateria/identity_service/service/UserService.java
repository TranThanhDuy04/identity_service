package com.devcateria.identity_service.service;

import com.devcateria.identity_service.dto.request.UserCreationRequest;
import com.devcateria.identity_service.dto.request.UserUpdateRequest;
import com.devcateria.identity_service.dto.response.UserResponse;
import com.devcateria.identity_service.entity.User;
import com.devcateria.identity_service.exception.AppException;
import com.devcateria.identity_service.exception.ErrorCode;
import com.devcateria.identity_service.mapper.UserMapper;
import com.devcateria.identity_service.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;
    public User createUser(UserCreationRequest request){
        if(userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toUser(request);
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public UserResponse getUser(String id){
        return userMapper.toUserResponse(userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found")));
    }

    public UserResponse updateUser(String userId, UserUpdateRequest request){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("user not found"));
        userMapper.upDateUser(user, request);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(String userId){
        userRepository.deleteById(userId);
    }
}
