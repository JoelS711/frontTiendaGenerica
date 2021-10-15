package Ciclo3.front.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

import Ciclo3.front.model.ClientesDAO;
import Ciclo3.front.model.VentasDAO;
import Ciclo3.front.vo.VentasVO;

@Controller
public class VentasController {

	private ArrayList<VentasVO> listarVentas;

	@Autowired
	private VentasDAO vendao;
	private ClientesDAO clidao;
	
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
	
	
}