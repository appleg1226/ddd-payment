package com.example.user.domain;

public interface UserRepository {

    User getByIdOrDefault(String id);

    String save(User user);
}
