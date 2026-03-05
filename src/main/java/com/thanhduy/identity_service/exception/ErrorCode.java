package com.thanhduy.identity_service.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error."),
    INVALID_KEY(1001, "Invalid message."),
    USER_EXISTED(1002, "User existed."),
    USERNAME_INVALID(1003,"Username must be at least 3 characters"),
    PASSWORD_INVALID(1004,"Password must be at least 8 characters"),
    USER_NOT_EXISTED(1005, "User not existed.")
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    int code;
    String message;

}
