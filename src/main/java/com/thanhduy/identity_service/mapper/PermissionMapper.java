package com.thanhduy.identity_service.mapper;

import com.thanhduy.identity_service.dto.request.PermissionRequest;
import com.thanhduy.identity_service.dto.request.UserCreationRequest;
import com.thanhduy.identity_service.dto.request.UserUpdateRequest;
import com.thanhduy.identity_service.dto.response.PermissionResponse;
import com.thanhduy.identity_service.dto.response.UserResponse;
import com.thanhduy.identity_service.entity.Permission;
import com.thanhduy.identity_service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
}
