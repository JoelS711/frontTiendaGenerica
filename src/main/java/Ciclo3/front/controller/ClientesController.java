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
import Ciclo3.front.vo.ClientesVO;

@Controller
public class ClientesController {

	@Autowired
	private ClientesDAO clidao;
	private ArrayList<ClientesVO> listarClientes;

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
			model.addAttribute("error", "C�dula Errada");

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
	
	@PostMapping("/cliente/crearCliente")
	public String creaCliente(@Validated ClientesVO cliente, BindingResult resultadoValidacion, Model model) {
		String redi;
		ClientesVO cli=clidao.consultarCliente(cliente);
		clidao = new ClientesDAO();
		if (resultadoValidacion.hasErrors()) {
			model.addAttribute("error", "Faltan datos del Cliente");
			redi = "/cliente/crearCliente";
		}else {
			if(cli !=null) {
				model.addAttribute("eror","Cliente ya existe");
				redi="/cliente/crearCliente";
			}else {
				model.addAttribute("usuario", clidao.crearCliente(cliente));
				redi = "/cliente/crearCliente";
				model.addAttribute("mensaje", "Cliente Creado");
			}
		}
		
		return redi;
	}
	@PostMapping("/ventas/Ventas")
	public String consultarClienteVenta(Model model, ClientesVO cliente) {

		clidao = new ClientesDAO();
		String redi;
		ClientesVO cli = clidao.consultarCliente(cliente);
		if(cli != null) {
			model.addAttribute("cliente", cli);
			redi = "/ventas/Ventas";
		}else {
			model.addAttribute("error", "Usuario no Existe");
			redi = "/ventas/Ventas";

		}
		return redi;
			}
	
	@PostMapping("/cliente/consultarCliente")
	public String consultarCliente(Model model, ClientesVO cliente) {
		
		clidao = new ClientesDAO();
		String redi;
		ClientesVO cli = clidao.consultarCliente(cliente);
		if(cli != null) {
			model.addAttribute("cliente", cli);
			redi ="/cliente/consultarCliente";
		}else {
			model.addAttribute("error", "Cliente Inexistente");
			redi ="/cliente/consultarCliente";
		}
		return "/cliente/consultarCliente";

	}
	
}

