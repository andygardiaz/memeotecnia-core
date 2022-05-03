package com.andygardiaz.memeotecnicacore.usuarios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findBy();
    Usuario findWithUsuarioByIdUsuario(Integer idUsuario);
    Usuario findByEmailAndContrasenna(String email, String contrasenna); 
}
