package com.andygardiaz.memeotecnicacore.colecciones;

import java.util.List;

import com.andygardiaz.memeotecnicacore.colecciones.proyecciones.ColeccionConMemes;
import com.andygardiaz.memeotecnicacore.colecciones.proyecciones.ColeccionSinMemes;

import org.springframework.stereotype.Service;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ColeccionesService {
    private final @NonNull ColeccionesRepository colRepository;
    public List<ColeccionSinMemes> findAll() {
        return colRepository.findBy();
    }
    public List<ColeccionSinMemes> searchByNombre(String search) {
        return colRepository.findByNombreContaining(search);
    }
    public ColeccionConMemes findById(int id) {
        return colRepository.findWithProductsByIdColeccion(id);
    }
    public Coleccion insert(Coleccion c) {
        return colRepository.save(c);
    }
    public Coleccion update(int id, Coleccion c) {
        c.setIdColeccion(id);
        return colRepository.save(c);
    }
    public void delete(int id) {
        colRepository.deleteById(id);
    }
}
