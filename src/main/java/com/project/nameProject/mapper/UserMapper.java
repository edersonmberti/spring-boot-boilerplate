package com.project.nameProject.mapper;

import com.project.nameProject.domain.Profile;
import com.project.nameProject.domain.User;
import com.project.nameProject.web.request.UserRequest;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User map(UserRequest request, boolean active, Profile profile){

        User response = new User();

        response.setName(request.getName());
        response.setEmail(request.getEmail());
        response.setPhotoUrl(request.getPhotoUrl());
        response.setPassword(request.getPassword());
        response.setActive(active);
        response.setProfile(profile);

        return response;

    }
}
