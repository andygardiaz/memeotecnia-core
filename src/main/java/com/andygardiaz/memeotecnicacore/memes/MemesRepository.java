package com.andygardiaz.memeotecnicacore.memes;

import com.andygardiaz.memeotecnicacore.memes.proyecciones.MemeConColeccion;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MemesRepository extends JpaRepository <Meme, Integer> {
    MemeConColeccion findWithCategoryByIdMeme(int idMeme);
}
