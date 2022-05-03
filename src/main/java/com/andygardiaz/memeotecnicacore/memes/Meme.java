package com.andygardiaz.memeotecnicacore.memes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Null;

import com.andygardiaz.memeotecnicacore.colecciones.Coleccion;
import com.andygardiaz.memeotecnicacore.denuncias.Denuncia;
import com.andygardiaz.memeotecnicacore.denuncias.proyecciones.DenunciaSinMeme;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor
@Entity
public class Meme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_meme")
    private int idMeme;
    private String rutaImagen;
    private String rutaOriginal;
    private String textoSuperior;
    private String textoInferior;
    private boolean privado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_coleccion")
    private Coleccion coleccion;

    @JsonBackReference
    @OneToMany( targetEntity = Denuncia.class,mappedBy = "id_meme", orphanRemoval = false, fetch = FetchType.LAZY)
    @Null(message = "No se pueden incluir denuncias")
    private List<DenunciaSinMeme> denuncia;
}
