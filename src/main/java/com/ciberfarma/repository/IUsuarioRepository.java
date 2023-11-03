package com.ciberfarma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciberfarma.model.Usuario;


@Repository
public interface IUsuarioRepository  extends JpaRepository<Usuario,Integer >{

	Usuario findByCorreoAndClave(String correo,String clave); 

}

