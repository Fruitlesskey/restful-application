package com.example.restfulapplication.enums;

public enum Permission {
    USER_READ("user_read"),
    USER_WRITE("user_write");

    private final String permission;
    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return this.permission;
    }

}
