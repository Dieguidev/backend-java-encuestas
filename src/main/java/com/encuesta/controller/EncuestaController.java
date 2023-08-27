package com.encuesta.controller;

import com.encuesta.model.Encuesta;
import com.encuesta.repositories.EncuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("api/encuestas")
public class EncuestaController {

    private final EncuestaRepository encuestaRepository;

    @Autowired
    public EncuestaController(EncuestaRepository encuestaRepository) {
        this.encuestaRepository = encuestaRepository;
    }

    @GetMapping
    public ResponseEntity<Iterable<Encuesta>> getEncuestas(){
        return new ResponseEntity<>(encuestaRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Encuesta> encuesta =encuestaRepository.findById(id);

        if(encuesta.isPresent()){
            return new ResponseEntity<>(encuesta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<?> updateEncuesta(@RequestBody Encuesta encuesta) {
        encuesta = encuestaRepository.save(encuesta);

        HttpHeaders httpHeaders = new HttpHeaders();
        URI newEncuestaUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(encuesta.getId()).toUri();
        httpHeaders.setLocation(newEncuestaUri);

        return new ResponseEntity<>(null,httpHeaders ,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEncuesta(@PathVariable Long id,@RequestBody)
}
