package com.devcateria.identity_service.mapper;

import com.devcateria.identity_service.dto.request.UserCreationRequest;
import com.devcateria.identity_service.dto.request.UserUpdateRequest;
import com.devcateria.identity_service.dto.response.UserResponse;
import com.devcateria.identity_service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserCreationRequest request);
    UserResponse toUserResponse(User user);

    void upDateUser(@MappingTarget User user, UserUpdateRequest request);



}
