package com.recuperativa.controllers;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.annotation.RequestCookieMap;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.recuperativa.models.Paciente;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {
@Autowired
    PacienteService pacienteService;

@RequestMapping("")
    public String paciente(@ModelAttribute("paciente") Paciente paciente) {
    
        return "paciente.jsp";
    }

@PostMapping("/guardar")
public String guardarPaciente(@Valid @ModelAttribute("paciente") Paciente paciete,
BindingResult resultado,
Model model) {

	//enviamos el objeto a persistir en base datos
	pacienteService.guardarPaciente(paciente);
	//obtener una lista pacientes
	List<Paciente> listaPacientes = pacienteService.findAll();
	//pasamos la lista de autos al jsp
	model.addAttribute("pacienteCapturados", listapacientes);
	return "mostrarPacientes.jsp";

}
