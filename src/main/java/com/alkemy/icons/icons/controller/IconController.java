package com.alkemy.icons.icons.controller;

import com.alkemy.icons.icons.dto.IconoDTO;
import com.alkemy.icons.icons.entity.IconsEntity;
import com.alkemy.icons.icons.service.implementacion.IconServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/icons")
public class IconController {

    @Autowired
    private IconServiceImple iconServiceImple;

    @PostMapping
    public ResponseEntity<IconoDTO> save (@RequestBody IconoDTO dto){
         IconoDTO iconSaved = iconServiceImple.save(dto);
         return ResponseEntity.status(HttpStatus.CREATED).body(iconSaved);
    }

    @GetMapping
    public ResponseEntity<List<IconoDTO>> findAllIcons(){
        List<IconoDTO> listadoDto = iconServiceImple.findAllIcons();
        return ResponseEntity.status(HttpStatus.OK).body(listadoDto);
    }






}
