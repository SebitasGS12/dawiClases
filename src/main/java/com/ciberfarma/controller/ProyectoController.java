package com.ciberfarma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ciberfarma.repository.IUsuarioRepository;

import lombok.experimental.PackagePrivate;

@Controller
public class ProyectoController {
	
	
	@Autowired
	private IUsuarioRepository repoUser;
	
	// crear las acciones o controlador
	// 1° determinar la forma de acceso
	// href / URL -> método get
	
	
	
	@GetMapping("/cargaLogin")
	public String abrirPagLogin() {
		// acciones....
		
		// página o recurso a redireccionar
		return "login";   
	}
	
	// Post --> Desde un form --> method post
	@PostMapping("/login")
	public String validarAcceso(
			@RequestParam("txtUsuario") String usuario, 
			@RequestParam("txtClave") String clave,
			Model model) {
		
		
		
		// acciones....
		if (repoUser.findByCorreoAndClave(usuario, clave) != null ) {
			// enviar información -> attribute("variable", valor)
			model.addAttribute("mensaje", "Bienvenido: " + usuario);
			model.addAttribute("cssmensaje", "alert alert-success");
		} else {
			model.addAttribute("mensaje", "Usuario o clave incorrecto");
			model.addAttribute("cssmensaje", "alert alert-danger");
		}
		
		// página de salida
		return "login";
	}
	
	
	
	
}
