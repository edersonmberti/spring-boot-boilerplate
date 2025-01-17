package com.project.nameProject.repository;

import com.project.nameProject.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String username);

    boolean existsByEmail(String email);

}
