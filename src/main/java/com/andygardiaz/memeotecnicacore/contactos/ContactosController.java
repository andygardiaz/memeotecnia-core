package com.andygardiaz.memeotecnicacore.contactos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/contactos")
public class ContactosController {
    private final @NonNull ContactosService conService;

    @GetMapping
    public Map<String, Object> findAll(@RequestParam(defaultValue = "") String search) {
        List<Contacto> conts;
        if(search.equals("")) {
            conts = conService.findAll();
        } else {
            conts = conService.searchByEmail(search);
        }
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("contactos", conts);
        return respuesta;
    }
    @GetMapping("/{id_contacto}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable int id_contacto) {
        Contacto conts = conService.findById(id_contacto);
        if(conts != null) {
            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("contacto", conts);
            return ResponseEntity.ok(respuesta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> insertContacto(@RequestBody @Valid Contacto c) {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("contacto", conService.insert(c));
        return respuesta;
    }

    @PutMapping("/{id_contacto}")
    public Map<String, Object> updateContacto(@PathVariable int id_contacto, @RequestBody @Valid Contacto c) {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("contacto", conService.update(id_contacto, c));
        return respuesta;
    }

    @DeleteMapping("/{id_contacto}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContacto(@PathVariable int id_contacto) {
        conService.delete(id_contacto);
    }

}
