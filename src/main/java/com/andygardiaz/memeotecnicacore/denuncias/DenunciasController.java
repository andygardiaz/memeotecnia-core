package com.andygardiaz.memeotecnicacore.denuncias;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.andygardiaz.memeotecnicacore.denuncias.proyecciones.DenunciaConMeme;
import com.andygardiaz.memeotecnicacore.denuncias.proyecciones.DenunciaSinMeme;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/denuncias")
public class DenunciasController {
    private final @NonNull DenunciasService denService;
    @GetMapping
    public Map<String, Object> findAll(@RequestParam(defaultValue = "") String search) {
        List<DenunciaSinMeme> dens;
        if(search.equals("")) {
            dens = denService.findAll();
        } else {
            dens = denService.searchByEmailContacto(search);
        }

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("denuncias", dens);
        return respuesta;
    }

    @GetMapping("/{id_denuncia}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable int id_denuncia) {
        DenunciaConMeme den = denService.findById(id_denuncia);
        if (den != null) {
            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("denuncia", den);
            return ResponseEntity.ok(respuesta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> insertDenuncia(@RequestBody @Valid Denuncia d) {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("denuncia", denService.insert(d));
        return respuesta;
    }

    @DeleteMapping("/{id_denuncia}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDenuncia(@PathVariable int id_denuncia) {
        denService.delete(id_denuncia);
    }
}
