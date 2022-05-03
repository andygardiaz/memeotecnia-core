package com.andygardiaz.memeotecnicacore.usuarios;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;


import org.springframework.stereotype.Service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsuariosService {
    private final @NonNull UsuariosRepository usuRepo;

    public List<Usuario> findAll() {
        return usuRepo.findBy();
    }

    public Usuario findById(int idUsuario) {
        return usuRepo.findWithUsuarioByIdUsuario(idUsuario);
    }
    public Usuario insert(Usuario u) throws NoSuchAlgorithmException {
        u.setContrasenna(encodePassword(u.getContrasenna()));
        return usuRepo.save(u);
    }
    public Usuario login(String email, String contrasenna) throws NoSuchAlgorithmException {
        return usuRepo.findByEmailAndContrasenna(email, encodePassword(contrasenna));
    }

    public Usuario update(Usuario u, int idUsuario) {
        if(usuRepo.existsById(idUsuario)) {
            u.setIdUsuario(idUsuario);
            return usuRepo.save(u);
        }
        return null; // No existe
    }
    public void delete(int idUsuario) {
        usuRepo.deleteById(idUsuario);
    }

    private String encodePassword(String pass) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(pass.getBytes(StandardCharsets.UTF_8));
		String encodedPass = Base64.getEncoder().encodeToString(hash);
		return encodedPass;
	}
}
