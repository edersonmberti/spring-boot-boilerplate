package com.project.nameProject.service.user;

import com.project.nameProject.domain.User;
import com.project.nameProject.exception.NotFoundException;
import com.project.nameProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SearchUserService {

    @Autowired
    private UserRepository repository;

    public User search(Long id){

        Optional<User> user = repository.findById(id);

        return user.orElseThrow(
                () -> new NotFoundException("Usuário não encontrado"));

    }

}
