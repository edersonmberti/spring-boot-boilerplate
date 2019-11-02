package com.project.nameProject.security;

import com.project.nameProject.domain.Profile;
import org.springframework.stereotype.Service;

@Service
public class ProfileDecodeService {

    private static final String ADMINISTRATOR_CREDENTIAL = "SWORDFISH";

    public Profile decode(String adminPassword){

        return ADMINISTRATOR_CREDENTIAL.equals(adminPassword) ? Profile.ADMINISTRATOR : Profile.USER;

    }

}
