package com.andygardiaz.memeotecnicacore.contactos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactosRepository extends JpaRepository<Contacto, Integer> {
    public List<Contacto> findBy();

    public Contacto findWithProductsByIdContacto(int idContacto);

    public List<Contacto> findByEmailContaining(String email); 
}
