package com.deximos.mirror_messenger.domain.user;
enum Role {
    ADMIN,
    GUEST
}

public record UserWithRole(User user, Role role) {}
