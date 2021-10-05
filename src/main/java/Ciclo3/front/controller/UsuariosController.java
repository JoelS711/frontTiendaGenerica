package Ciclo3.front.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Ciclo3.front.model.UsuariosDAO;
import Ciclo3.front.vo.UsuariosVO;



@Controller
public class UsuariosController {
	
	private ArrayList<UsuariosVO> listarUsuarios;
	
	@Autowired
	private UsuariosDAO usudao;
	
	@PostMapping("/auth")
	public String auth(Model model, UsuariosVO usuario) {
		usudao =  new UsuariosDAO();
		String redirec;
		UsuariosVO usr = usudao.auth(usuario);
		if(usr != null) {
		model.addAttribute("usuario", usr);
		redirec = "Menu";
		}else {
		model.addAttribute("error", "Usuario o constraseña invalidos.");
		redirec = "auth";
		}
		return redirec;
	}
	
	
	@PostMapping("/usuario/crearUsuario")
	public String crearUsuario(Model model, UsuariosVO usuario) {

		usudao = new UsuariosDAO();
		
		model.addAttribute("usuario", usudao.crearUsuario(usuario));
		listarUsuario();
		model.addAttribute("cedula", getListarUsuarios());

		return "/usuario/crearUsuario";

			}
	
	@GetMapping("/usuario/crearUsuario")
	public String usuario(Model model) {
		listarUsuario();
		model.addAttribute("usuario", getListarUsuarios());
		//model.addAttribute("usuarios", clienteTienda.getUsuarios());
		return "/usuario/crearUsuario";
	}
	
	@PostMapping("/usuario/actualizarUsuario")
	public String actualizarUsuario(Model model, UsuariosVO usuario) {

		usudao = new UsuariosDAO();
		
		model.addAttribute("cedula", usudao.crearUsuario(usuario));
//		listarUsuario();
//		model.addAttribute("cedula", getListarUsuarios());

		return "/usuario/actualizarUsuario";

			}
	
	public void listarUsuario() {
		UsuariosDAO objEstDao = new UsuariosDAO();
		String json = objEstDao.listarUsuarios();
		if(json  != null) {
            Type listType = new TypeToken<ArrayList<UsuariosVO>>(){}.getType();
            Gson gson = new Gson();
            listarUsuarios = gson.fromJson(json, listType);
        }else {
        	listarUsuarios = new ArrayList<UsuariosVO>();
        }
	}

	public ArrayList<UsuariosVO> getListarUsuarios() {
		return listarUsuarios;
	}

	public void setListarUsuarios(ArrayList<UsuariosVO> listarUsuarios) {
		this.listarUsuarios = listarUsuarios;
	}
	
	
	
	
}
