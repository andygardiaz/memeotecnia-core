package com.andygardiaz.memeotecnicacore.colecciones.proyecciones;

import java.util.List;

import com.andygardiaz.memeotecnicacore.memes.Meme;

public interface ColeccionConMemes {
    int getIdColeccion();
    String getNombre();
    List<Meme> getMemes();
        default int getNumMemes() {
            return getMemes().size();
        }
}
