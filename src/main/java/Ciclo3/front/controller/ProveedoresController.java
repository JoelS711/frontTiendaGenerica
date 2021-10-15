package Ciclo3.front.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Ciclo3.front.model.ProveedoresDAO;
import Ciclo3.front.vo.ProveedoresVO;

@Controller
public class ProveedoresController {
	
private ArrayList<ProveedoresVO> listarProveedores;
	
	@Autowired
	private ProveedoresDAO prodao;

	@PostMapping("/proveedor/crearProveedor")
	public String crearProveedor( @Validated ProveedoresVO proveedor, BindingResult resultadoValidacion,Model model) {
		String redi;
		ProveedoresVO pro = prodao.consultarProveedor(proveedor);
		prodao = new ProveedoresDAO();
		if(resultadoValidacion.hasErrors()) {
			model.addAttribute("error", "Faltan datos del proveedor");
			redi="/proveedor/crearProveedor";
		}else{	
			if(pro != null) {
				model.addAttribute("error", "Proveedor ya existe");
				redi="/proveedor/crearProveedor";		
		}else {	
			model.addAttribute("proveedor", prodao.crearProveedor(proveedor));
			redi="/proveedor/crearProveedor";
			model.addAttribute("mensaje", "Proveedor Creado");
		}
		}
		return redi;
	}

	@PostMapping("/proveedor/actualizarProveedor")
	public String actualizarProveedor(@Validated ProveedoresVO proveedor, BindingResult resultadoValidacion,Model model) {
		String redi;
		ProveedoresVO pro = prodao.consultarProveedor(proveedor);
		prodao = new ProveedoresDAO();
		if(resultadoValidacion.hasErrors()) {
			model.addAttribute("error", "Datos faltantes");
			redi="/proveedor/actualizarProveedor";
		}else{
			if(pro != null) {
				model.addAttribute("proveedor", prodao.actualizarProveedor(proveedor));
				redi="/proveedor/actualizarProveedor";
				model.addAttribute("mensaje", "Datos del Proveedor Actualizados");
			}else {
				model.addAttribute("error", "Proveedor no Registrado");
				redi="/proveedor/actualizarProveedor";
			}
			
		}
		return redi;
	}
	
	@PostMapping("/proveedor/consultarProveedor")
	public String consultarProveedor(Model model, ProveedoresVO proveedor) {

		prodao = new ProveedoresDAO();
		model.addAttribute("nit", prodao.consultarProveedor(proveedor));

		return "/proveedor/consultarProveedor";

			}
	
	public void listarProveedor() {
		ProveedoresDAO objEstDao = new ProveedoresDAO();
		String json = objEstDao.listarProveedores();
		if(json  != null) {
            Type listType = new TypeToken<ArrayList<ProveedoresVO>>(){}.getType();
            Gson gson = new Gson();
            listarProveedores = gson.fromJson(json, listType);
        }else {
        	listarProveedores = new ArrayList<ProveedoresVO>();
        }
	}

	public ArrayList<ProveedoresVO> getListarProveedores() {
		return listarProveedores;
	}

	public void setListarProveedores(ArrayList<ProveedoresVO> listarProveedores) {
		this.listarProveedores = listarProveedores;
	}
	
	@PostMapping("/proveedor/eliminarProveedor")
	public String eliminarProveedor(Model model, ProveedoresVO proveedor) {
		ProveedoresVO pro = prodao.consultarProveedor(proveedor);
		prodao = new ProveedoresDAO();
		if(pro != null) {
			model.addAttribute("nit", prodao.eliminarProveedor(proveedor));
			model.addAttribute("mensaje", "Datos del Proveedor Borrados");

		}else {
			model.addAttribute("error", "NIT Errado");
		
		}
		return "/proveedor/eliminarProveedor";
	}
}
