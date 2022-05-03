package com.andygardiaz.memeotecnicacore.denuncias;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.andygardiaz.memeotecnicacore.memes.Meme;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor
@Entity
public class Denuncia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDenuncia;
    private String emailContacto;
    private String razonDenuncia;
    private String descripcion;
    private Integer id_meme;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_meme", insertable = false, updatable = false)
    private Meme meme;
}

