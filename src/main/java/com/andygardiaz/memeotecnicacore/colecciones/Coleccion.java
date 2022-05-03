package com.andygardiaz.memeotecnicacore.colecciones;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;

import com.andygardiaz.memeotecnicacore.memes.Meme;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@Entity
public class Coleccion {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idColeccion;
    @NotEmpty(message = "El nombre es requerido y no puede estar vacío")
    private String nombre;

    @JsonBackReference
    @OneToMany(mappedBy = "coleccion")
    @Null(message = "No se pueden incluir memes")
    private List<Meme> memes;
}
