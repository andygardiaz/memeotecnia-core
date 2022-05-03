package com.andygardiaz.memeotecnicacore.memes;

import com.andygardiaz.memeotecnicacore.colecciones.ColeccionesRepository;
import com.andygardiaz.memeotecnicacore.memes.proyecciones.MemeConColeccion;
import com.andygardiaz.memeotecnicacore.utils.ImageUtils;


import org.springframework.stereotype.Service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class MemesService {
    private final @NonNull MemesRepository memRepo;
    private final @NonNull ColeccionesRepository colRepo;
    private final @NonNull ImageUtils imgUtils;

    public MemeConColeccion findById(int id) {
        return memRepo.findWithCategoryByIdMeme(id);
    }
    public Meme insert(Meme m) {
        System.out.println(m.getRutaImagen());
        System.out.println(m.getRutaOriginal());
        String ruta = imgUtils.saveImageBase64("memes", m.getRutaImagen());
        if(!m.getRutaOriginal().startsWith("http")){
            String ruta_original = imgUtils.saveImageBase64("originales", m.getRutaOriginal());
            m.setRutaOriginal(ruta_original);
        }
        m.setRutaImagen(ruta);
        return memRepo.save(m);
    }
    public void delete(int id) {
        memRepo.deleteById(id);
    }
}
