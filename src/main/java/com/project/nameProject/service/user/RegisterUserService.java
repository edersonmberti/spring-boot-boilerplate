package com.project.nameProject.service.user;

import com.project.nameProject.domain.Profile;
import com.project.nameProject.domain.User;
import com.project.nameProject.exception.BusinessRuleException;
import com.project.nameProject.mapper.UserMapper;
import com.project.nameProject.repository.UserRepository;
import com.project.nameProject.security.ProfileDecodeService;
import com.project.nameProject.web.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ProfileDecodeService profileDecodeService;

    public User register(UserRequest request) {

        boolean userRegistred = repository.existsByEmail(request.getEmail());

        if(userRegistred){
            throw new BusinessRuleException("E-mail já cadastrado");
        }

        Profile profile = profileDecodeService.decode(request.getAdministratorCredentials());

        User user = mapper.map(request, true, profile);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        repository.save(user);

        return user;
    }
}
