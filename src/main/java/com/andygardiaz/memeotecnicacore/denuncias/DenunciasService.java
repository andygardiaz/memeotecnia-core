package com.andygardiaz.memeotecnicacore.denuncias;

import com.andygardiaz.memeotecnicacore.memes.MemesRepository;

import java.util.List;

import com.andygardiaz.memeotecnicacore.denuncias.proyecciones.DenunciaConMeme;
import com.andygardiaz.memeotecnicacore.denuncias.proyecciones.DenunciaSinMeme;

import org.springframework.stereotype.Service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class DenunciasService {
    private final @NonNull DenunciasRepository denRepo;
    private final @NonNull MemesRepository memRepo;

    public List<DenunciaSinMeme> findAll() {
        return denRepo.findBy();
    }

    public List<DenunciaSinMeme> searchByEmailContacto(String search) {
        return denRepo.findByEmailContactoContaining(search);
    }

    public DenunciaConMeme findById(int id) {
        return denRepo.findWithCategoryByIdDenuncia(id);
    }
    public Denuncia insert(Denuncia d) {
        return denRepo.save(d);
    }
    public void delete(int id) {
        denRepo.deleteById(id);
    }
}

