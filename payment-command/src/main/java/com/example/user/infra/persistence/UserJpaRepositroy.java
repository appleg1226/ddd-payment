package com.example.user.infra.persistence;

import com.example.user.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserJpaRepositroy extends CrudRepository<User, String> {
}
