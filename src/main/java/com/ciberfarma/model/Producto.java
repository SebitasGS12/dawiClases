package com.ciberfarma.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Table(name="tb_productos")
@Entity
public class Producto {
	@Id
	private String id_prod;
	private String des_prod;
	private int stk_prod;
	private Double pre_prod;
	private int idcategoria;

	@ManyToOne() 
	@JoinColumn(name="idcategoria" , insertable = false,updatable = false)
	private Categoria objCategoria;
	
	private int est_prod;
	private int idproveedor;
	
	
	@ManyToOne()
	@JoinColumn(name="idproveedor" , insertable = false,updatable = false)
	private Proveedor objProveedor;


	public String getId_prod() {
		return id_prod;
	}


	public void setId_prod(String id_prod) {
		this.id_prod = id_prod;
	}


	public String getDes_prod() {
		return des_prod;
	}


	public void setDes_prod(String des_prod) {
		this.des_prod = des_prod;
	}


	public int getStk_prod() {
		return stk_prod;
	}


	public void setStk_prod(int stk_prod) {
		this.stk_prod = stk_prod;
	}


	public Double getPre_prod() {
		return pre_prod;
	}


	public void setPre_prod(Double pre_prod) {
		this.pre_prod = pre_prod;
	}


	public int getIdcategoria() {
		return idcategoria;
	}


	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}


	public Categoria getObjCategoria() {
		return objCategoria;
	}


	public void setObjCategoria(Categoria objCategoria) {
		this.objCategoria = objCategoria;
	}


	public int getEst_prod() {
		return est_prod;
	}


	public void setEst_prod(int est_prod) {
		this.est_prod = est_prod;
	}


	public int getIdproveedor() {
		return idproveedor;
	}


	public void setIdproveedor(int idproveedor) {
		this.idproveedor = idproveedor;
	}


	public Proveedor getObjProveedor() {
		return objProveedor;
	}


	public void setObjProveedor(Proveedor objProveedor) {
		this.objProveedor = objProveedor;
	}


	
	
	
}
