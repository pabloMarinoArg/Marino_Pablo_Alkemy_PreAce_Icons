package com.alkemy.icons.icons.service;

import com.alkemy.icons.icons.dto.ContinenteDTO;

import java.util.List;

public interface ContinenteService {

    ContinenteDTO save (ContinenteDTO continenteDTO);
    public List<ContinenteDTO> findAllContinentes();




}
