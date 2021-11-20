package com.alkemy.icons.icons.controller;

import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.service.ContinenteService;
import com.alkemy.icons.icons.service.implementacion.ContinenteServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/continentes")
public class ContinenteController {

    @Autowired
    private ContinenteService continenteService;


    @PostMapping
    public ResponseEntity<ContinenteDTO> save (@RequestBody ContinenteDTO continente){
        ContinenteDTO continenteGuardado = continenteService.save(continente);
        return ResponseEntity.status(HttpStatus.CREATED).body(continenteGuardado);
    }
    @GetMapping
    public ResponseEntity<List<ContinenteDTO>> findAll(){
        List<ContinenteDTO> listado = continenteService.findAllContinentes();
        return ResponseEntity.ok().body(listado);
    }



}
