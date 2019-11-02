package com.project.nameProject.web;

import com.project.nameProject.domain.User;
import com.project.nameProject.service.user.RegisterUserService;
import com.project.nameProject.web.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/public/users")
public class PublicUserController {

    @Autowired
    private RegisterUserService registerUserService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User register(@Valid @RequestBody UserRequest request){
        return registerUserService.register(request);
    }

}
