package com.andygardiaz.memeotecnicacore.denuncias;

import java.util.List;

import com.andygardiaz.memeotecnicacore.denuncias.proyecciones.DenunciaConMeme;
import com.andygardiaz.memeotecnicacore.denuncias.proyecciones.DenunciaSinMeme;

import org.springframework.data.jpa.repository.JpaRepository;



public interface DenunciasRepository extends JpaRepository <Denuncia, Integer> {

    public List<DenunciaSinMeme> findBy();
    DenunciaConMeme findWithCategoryByIdDenuncia(int findWithCategoryByIdDenuncia);

    public List<DenunciaSinMeme> findByEmailContactoContaining(String razonDenuncia); 
}
