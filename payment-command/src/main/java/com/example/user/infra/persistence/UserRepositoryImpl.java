package com.example.user.infra.persistence;

import com.example.user.domain.User;
import com.example.user.domain.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepositroy jpaRepository;

    @Override
    public String save(User user) {
        return jpaRepository.save(user).getUserId();
    }

    @Override
    public User getByIdOrDefault(String id) {
        Optional<User> found = jpaRepository.findById(id);
        return found.orElse(jpaRepository.save(User.newUser(id)));
    }

    @Override
    public Optional<User> findById(String id) {
        return jpaRepository.findById(id);
    }
}
