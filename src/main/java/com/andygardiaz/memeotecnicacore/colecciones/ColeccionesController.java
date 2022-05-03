package com.andygardiaz.memeotecnicacore.colecciones;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.andygardiaz.memeotecnicacore.colecciones.proyecciones.ColeccionSinMemes;
import com.andygardiaz.memeotecnicacore.colecciones.proyecciones.ColeccionConMemes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/colecciones")
public class ColeccionesController {
    private final @NonNull ColeccionesService colService;

    @GetMapping
    public Map<String, Object> findAll(@RequestParam(defaultValue = "") String search) {
        List<ColeccionSinMemes> cols;
        if(search.equals("")) {
            cols = colService.findAll();
        } else {
            cols = colService.searchByNombre(search);
        }

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("colecciones", cols);
        return respuesta;
    }

    @GetMapping("/{id_coleccion}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable int id_coleccion) {
        ColeccionConMemes col = colService.findById(id_coleccion);
        if(col != null) {
            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("coleccion", col);
            return ResponseEntity.ok(respuesta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> insertColeccion(@RequestBody @Valid Coleccion c) {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("coleccion", colService.insert(c));
        return respuesta;
    }

    @PutMapping("/{id_coleccion}")
    public Map<String, Object> updateColeccion(@PathVariable int id_coleccion, @RequestBody @Valid Coleccion c) {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("coleccion", colService.update(id_coleccion, c));
        return respuesta;
    }

    @DeleteMapping("/{id_coleccion}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategoria(@PathVariable int id_coleccion) {
        colService.delete(id_coleccion);
    }
}
