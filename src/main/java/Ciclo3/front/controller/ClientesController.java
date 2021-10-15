package Ciclo3.front.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

import Ciclo3.front.model.ClientesDAO;
import Ciclo3.front.model.UsuariosDAO;
import Ciclo3.front.vo.ClientesVO;
import Ciclo3.front.vo.UsuariosVO;

@Controller
public class ClientesController {

	@Autowired
	private ClientesDAO clidao;

	@PostMapping("/cliente/actualizarCliente")
	public String actualizarCliente(Model model, @Validated ClientesVO cliente, BindingResult resultadoValidacion) {
		String redic;
		clidao = new ClientesDAO();
		ClientesVO cli = clidao.actualizarCliente(cliente);
		if (resultadoValidacion.hasErrors()) {
			model.addAttribute("error", "Faltan datos del usuario");
			redic = "/cliente/actualizarCliente";
		} else {
			if (cli != null) {
				model.addAttribute("cedula", clidao.actualizarCliente(cliente));
				redic = "/cliente/actualizarCliente";
				model.addAttribute("mensaje", "Cliente Actualizado");
			} else {
				model.addAttribute("error", "Cliente no registrado");
				redic = "/cliente/actualizarCliente";
			}
		}
		return "/cliente/actualizarCliente";

	}

	@PostMapping("/cliente/eliminarCliente")
	public String eliminarCliente(Model model, ClientesVO cli) {
		ClientesVO objCli = clidao.consultarCliente(cli);
		clidao = new ClientesDAO();
		if (objCli != null) {
			model.addAttribute("cedula", clidao.eliminarCliente(cli));
			model.addAttribute("mensaje", "Datos del Cliente Borrados");

		} else {
			model.addAttribute("error", "Cï¿½dula Errada");

		}
		return "/cliente/eliminarCliente";
	}
	
	public void listarCliente() {
		ClientesDAO objEstDao = new ClientesDAO();
		String json = objEstDao.listarClientes();
		if(json  != null) {
            Type listType = new TypeToken<ArrayList<ClientesVO>>(){}.getType();
            Gson gson = new Gson();
            listarClientes = gson.fromJson(json, listType);
        }else {
        	listarClientes = new ArrayList<ClientesVO>();
        }
	}

public ArrayList<ClientesVO> getListarClientes() {
	return listarClientes;
}

	public void setListarClientes(ArrayList<ClientesVO> listarClientes) {
		this.listarClientes = listarClientes;
	}
	
	@PostMapping("/cliente/eliminarCliente")
	public String eliminarCliente(Model model, ClientesVO cliente) {
		ClientesVO cli = clidao.consultarCliente(cliente);
		clidao = new ClientesDAO();
		if(cli != null) {
			model.addAttribute("cedula", clidao.eliminarCliente(cliente));
			model.addAttribute("mensaje", "Datos del Cliente Borrados");

		}else {
			model.addAttribute("error", "Cédula Errada");
		
		}
		return "/cliente/eliminarCliente";
	}
}
}
