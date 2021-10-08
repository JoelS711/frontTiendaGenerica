package Ciclo3.front.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import Ciclo3.front.model.ClientesDAO;
import Ciclo3.front.vo.ClientesVO;

@Controller
public class ClientesController {

	@Autowired
	private ClientesDAO clidao;
	
	@PostMapping("/cliente/actualizarCliente")
	public String actualizarCliente(Model model, ClientesVO cliente) {

		clidao = new ClientesDAO();
		
		model.addAttribute("cedula", clidao.actualizarCliente(cliente));
//		listarUsuario();
//		model.addAttribute("cedula", getListarUsuarios());

		return "/cliente/actualizarCliente";

			}
}
