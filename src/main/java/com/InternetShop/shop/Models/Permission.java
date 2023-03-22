package com.InternetShop.shop.Models;

public enum Permission {
    USERS_READ("users:read"),
    USERS_WRITE("users:write");
    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
