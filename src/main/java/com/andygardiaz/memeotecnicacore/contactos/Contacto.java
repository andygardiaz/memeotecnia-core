package com.andygardiaz.memeotecnicacore.contactos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@Entity
public class Contacto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idContacto;
    @NotEmpty(message = "El email es requerido y no puede estar vacío")
    @Email
    private String email;
    @NotEmpty
    private String asunto;
    @NotEmpty
    private String descripcion;
}
