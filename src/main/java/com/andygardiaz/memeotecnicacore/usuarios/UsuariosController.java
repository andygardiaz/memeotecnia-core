package com.andygardiaz.memeotecnicacore.usuarios;

import java.util.List;

import javax.validation.Valid;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    private final @NonNull UsuariosService usuService;

    @GetMapping
    public List<Usuario> findAll() {
        return usuService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable int id) {
        Usuario u = usuService.findById(id);
        if(u == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(u);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@RequestBody @Valid Usuario usuario, @PathVariable int id) {
        Usuario u = usuService.update(usuario, id);
        if(u == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(u);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategoria(@PathVariable int id) {
        usuService.delete(id);
    }

}
