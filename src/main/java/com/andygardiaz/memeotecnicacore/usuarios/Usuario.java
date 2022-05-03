package com.andygardiaz.memeotecnicacore.usuarios;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;


import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Null
    private Integer idUsuario;
    @NotNull(message = "El nombre de usuario es obligatorio")
    @Size(min = 4)
    private String usuario;
    @NotNull
    @Email
    private String email;
    @NotEmpty
    private String contrasenna;
    @NotEmpty
    private String telefono;
    @NotEmpty
    private String rol;
}
