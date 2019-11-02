package com.project.nameProject.web.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class UserRequest {

    @NotEmpty(message = "O nome é obrigatório")
    private String name;

    @NotEmpty
    @Email(message = "O e-mail deve estar em um formato válido")
    private String email;

    @NotEmpty
    @Size(min = 6, message = "A senha precisa ter no mínimo 6 caracteres")
    private String password;

    @NotEmpty(message = "A foto é obrigatória")
    private String photoUrl;

    private String administratorCredentials;
}
