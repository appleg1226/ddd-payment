package com.example.user.domain;

import java.util.Optional;

public interface UserRepository {

    User getByIdOrDefault(String id);

    String save(User user);

    Optional<User> findById(String id);
}
