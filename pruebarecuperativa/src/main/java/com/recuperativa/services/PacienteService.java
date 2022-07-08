package com.recuperativa.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class pacienteService {
    @Autowired
    PacienteRepository pacienteRepository;
    
}
