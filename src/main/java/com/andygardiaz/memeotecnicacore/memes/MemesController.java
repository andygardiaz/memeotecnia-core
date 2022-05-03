package com.andygardiaz.memeotecnicacore.memes;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import com.andygardiaz.memeotecnicacore.memes.proyecciones.MemeConColeccion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("/memes")

public class MemesController {
    private final @NonNull MemesService memService;
    @GetMapping("/{id_meme}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable int id_meme) {
        MemeConColeccion mem = memService.findById(id_meme);
        if(mem != null) {
            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("meme", mem);
            return ResponseEntity.ok(respuesta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> insertMeme(@RequestBody @Valid Meme m) {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("meme", memService.insert(m));
        m.setRutaImagen(ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString() + "/" + m.getRutaImagen());
        m.setRutaOriginal(ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString() + "/" + m.getRutaOriginal());
        return respuesta;
    }

    @DeleteMapping("/{id_meme}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMeme(@PathVariable int id_meme) {
        memService.delete(id_meme);
    }

}
