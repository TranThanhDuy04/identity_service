package com.thanhduy.identity_service.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error."),
    UNVALID_KEY(1001, "Unvalid message."),
    USER_EXISTED(1002, "User existed."),
    USERNAME_UNVALID(1003,"Username must be at least 3 characters"),
    PASSWORD_UNVALID(1004,"Password must be at least 8 characters")
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
