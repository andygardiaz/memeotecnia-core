package com.andygardiaz.memeotecnicacore.contactos;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ContactosService {
    private final @NonNull ContactosRepository conRepository;
    public List<Contacto> findAll() {
        return conRepository.findBy();
    }

    public List<Contacto> searchByEmail(String search) {
        return conRepository.findByEmailContaining(search);
    }

    public Contacto findById(int id) {
        return conRepository.findWithProductsByIdContacto(id);
    }

    public Contacto insert(Contacto c) {
        return conRepository.save(c);
    }

    public Contacto update(int id, Contacto c) {
        c.setIdContacto(id);
        return conRepository.save(c);
    }

    public void delete(int id) {
        conRepository.deleteById(id);
    }
}
