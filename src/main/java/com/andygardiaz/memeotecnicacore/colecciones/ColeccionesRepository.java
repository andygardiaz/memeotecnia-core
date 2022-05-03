package com.andygardiaz.memeotecnicacore.colecciones;
import java.util.List;

import com.andygardiaz.memeotecnicacore.colecciones.proyecciones.ColeccionConMemes;
import com.andygardiaz.memeotecnicacore.colecciones.proyecciones.ColeccionSinMemes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ColeccionesRepository extends JpaRepository<Coleccion, Integer> {
    public List<ColeccionSinMemes> findBy();

    public ColeccionConMemes findWithProductsByIdColeccion(int idColeccion);

    public List<ColeccionSinMemes> findByNombreContaining(String nombre); 
}
