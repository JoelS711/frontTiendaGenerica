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

import Ciclo3.front.model.ClientesDAO;
import Ciclo3.front.model.VentasDAO;
import Ciclo3.front.vo.ClientesVO;
import Ciclo3.front.vo.ReportesVO;
import Ciclo3.front.vo.VentasVO;

@Controller
public class VentasController {

	

	@Autowired
	private VentasDAO vendao;
	private ClientesDAO clidao;
	private ArrayList<ReportesVO> listarVentas;
	
	@PostMapping("/venta/crearVenta")
	public String crearVenta(@Validated VentasVO venta, BindingResult resultadoValidacion, Model model) {
		String redi;
		vendao = new VentasDAO();
		if (resultadoValidacion.hasErrors()) {
			model.addAttribute("error", "Datos incorrectos");
			redi = "/venta/Ventas";
		} else {
			model.addAttribute("usuario", vendao.crearVenta(venta));
			redi = "/venta/Ventas";
			model.addAttribute("mensaje", "Venta creada");
		}
		return redi;
	}
	
	
	public void listarVentas() {
		VentasDAO vdao = new VentasDAO();
		String json = vdao.listarVentas();
		if(json  != null) {
            Type listType = new TypeToken<ArrayList<ReportesVO>>(){}.getType();
            Gson gson = new Gson();
            listarVentas = gson.fromJson(json, listType);
        }else {
        	listarVentas = new ArrayList<ReportesVO>();
        }
	}

public ArrayList<ReportesVO> getListarVentas() {
	return listarVentas;
}

	public void setListarVentas(ArrayList<ReportesVO> listarVentas) {
		this.listarVentas = listarVentas;
	}
	
	
}