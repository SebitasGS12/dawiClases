package com.ciberfarma.model;

import org.springframework.core.annotation.AliasFor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="tb_usuarios")
@Entity
public class Usuario {
	@Id
	private  int cod_usua;
	private String nom_usua;
	private String ape_usua;
	
	@Column(name ="usr_usua")
	private String correo;
	
	@Column(name ="cla_usua")
	private String clave;
	private String fna_usua;
	private String idtipo;
	private  int est_usua;
}
