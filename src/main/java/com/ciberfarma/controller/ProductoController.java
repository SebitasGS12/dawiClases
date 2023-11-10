package com.ciberfarma.controller;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.ciberfarma.model.Producto;
import com.ciberfarma.repository.ICategoriaRepository;
import com.ciberfarma.repository.IProductoRepository;
import com.ciberfarma.repository.IProveedorRepository;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
public class ProductoController {

	//Crear los accesos
	//Autoimplementar todos los procesos
	@Autowired
	private ICategoriaRepository repoPro;
	
	@Autowired
	private IProveedorRepository repoProvedor;

	
	@Autowired
	private IProductoRepository repoProducto;

	
	@Autowired
	private DataSource dataSource; // javax.sql
	@Autowired
	private ResourceLoader resourceLoader; // core.io
	
	//Get
	
	@GetMapping("/cargar")
	public String abrirCrudProductos(Model model) {
		//acciones
		
		model.addAttribute("lstCategoria",repoPro.findAll());
		model.addAttribute("lstProveedor",repoProvedor.findAll());
		model.addAttribute("lstProducto",repoProducto.findAll());
		
		model.addAttribute("producto", new Producto());
		
		
		return "crudProductos";
		
	}
	
	@GetMapping("/editar/{id_prod}")
	public String editarProducto(Model model , @PathVariable("id_prod") String id) {
		
		Producto pro = repoProducto.findById(id).get();
		
		System.out.println(pro.getDes_prod());

		
		model.addAttribute("lstCategoria",repoPro.findAll());
		model.addAttribute("lstProveedor",repoProvedor.findAll());
		model.addAttribute("lstProducto",repoProducto.findAll());
		model.addAttribute("producto",pro);
		
		
		return "crudProductos";
	}
	
	
	
	@PostMapping("/grabar")
	public String enviarProducto(Model model,@ModelAttribute("producto") Producto producto) {

		
		String mensaje ="";
		try {
			
			repoProducto.save(producto);
			mensaje = "Guardado Exitoso!";
			model.addAttribute("cssmensaje", "alert alert-success");		
		} catch (Exception e) {
			
			mensaje = "Error al guardar el producto : \n"+e.getMessage();
				
			model.addAttribute("cssmensaje", "alert alert-danger");
		}

		model.addAttribute("mensaje", mensaje);
		
		
		return "redirect:/cargar";
		
	}
	
	
	
	@GetMapping("/reportes")
	public void reportes(HttpServletResponse response) {
		
		
		//response.setHeader("Content-Disposition", "attachment; filename=\"reporte.pdf\";");
		response.setHeader("Content-Disposition", "inline;");
		response.setContentType("application/pdf");
		try {
			
			//Devuelve el recurso
		String ru = resourceLoader.getResource("classpath:demo02.jasper").getURI().getPath();
		//comvina el jasper con la data
		JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
 
		OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
		e.printStackTrace();
		}
				
	}

	
	
	
	
	
		
	
}
