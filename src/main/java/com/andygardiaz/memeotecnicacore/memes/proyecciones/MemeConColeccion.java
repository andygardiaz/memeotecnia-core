package com.andygardiaz.memeotecnicacore.memes.proyecciones;

import com.andygardiaz.memeotecnicacore.colecciones.proyecciones.ColeccionSinMemes;

public interface MemeConColeccion {
    int getIdMeme();
    String getRutaImagen();
    String getRutaOriginal();
    String getTextoSuperior();
    ColeccionSinMemes getColeccion();
    String getTextoInferior();
    boolean getPrivado();
}
