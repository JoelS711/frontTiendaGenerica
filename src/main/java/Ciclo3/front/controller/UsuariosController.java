package Ciclo3.front.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
		usudao = new UsuariosDAO();
		String redirec;
		UsuariosVO usr = usudao.auth(usuario);
		if (usr != null) {
			model.addAttribute("usuario", usr);
			redirec = "Menu";
		} else {
			model.addAttribute("error", "Usuario o constraseña invalidos.");
			redirec = "auth";
		}
		return redirec;
	}

	@PostMapping("/usuario/crearUsuario")
	public String crearUsuario(@Validated UsuariosVO usuario, BindingResult resultadoValidacion, Model model) {
		String redi;
		UsuariosVO usr=usudao.consultarUsuario(usuario);
		usudao = new UsuariosDAO();
		if (resultadoValidacion.hasErrors()) {
			model.addAttribute("error", "Faltan datos del usuario");
			redi = "/usuario/crearUsuario";
		}else {
			if(usr !=null) {
				model.addAttribute("eror","Usuario ya existe");
				redi="/usuario/crearUsuario";
			}else {
				model.addAttribute("usuario", usudao.crearUsuario(usuario));
				redi = "/usuario/crearUsuario";
				model.addAttribute("mensaje", "Usuario Creado");
			}
		}
		
		return redi;
	}


	@PostMapping("/usuario/actualizarUsuario")
	public String actualizarUsuario(Model model,@Validated UsuariosVO usuario, BindingResult resultadoValidacion) {
		String redic;
		usudao = new UsuariosDAO();
		UsuariosVO usr = usudao.actualizarUsuario(usuario);
		if(resultadoValidacion.hasErrors()) {
			model.addAttribute("error", "Faltan datos del usuario");
			redic = "/usuario/actualizarUsuario";
		}else {
			if(usr != null) {
				model.addAttribute("cedula", usudao.actualizarUsuario(usuario));
				redic = "/usuario/actualizarUsuario";
				model.addAttribute("mensaje", "Usuario Actualizado");
			}else {
				model.addAttribute("error", "Usuario no registrado");
				redic = "/usuario/actualizarUsuario";
			}
		}

		return "/usuario/actualizarUsuario";
	}

	@PostMapping("/usuario/consultarUsuario")
	public String consultarUsuario(Model model, UsuariosVO usuario) {

		usudao = new UsuariosDAO();
		String redi;
		UsuariosVO usr = usudao.consultarUsuario(usuario);
		if(usr != null) {
			model.addAttribute("usuario", usr);
			redi = "/usuario/consultarUsuario";
		}else {
			model.addAttribute("noconsultar", "Usuario no Existe");
			redi = "/usuario/consultarUsuario";

		}
		return redi;
			}

	public void listarUsuario() {
		UsuariosDAO objEstDao = new UsuariosDAO();
		String json = objEstDao.listarUsuarios();
		if (json != null) {
			Type listType = new TypeToken<ArrayList<UsuariosVO>>() {
			}.getType();
			Gson gson = new Gson();
			listarUsuarios = gson.fromJson(json, listType);
		} else {
			listarUsuarios = new ArrayList<UsuariosVO>();
		}

		if(json  != null) {
            Type listType = new TypeToken<ArrayList<UsuariosVO>>(){}.getType();
            Gson gson = new Gson();
            listarUsuarios = gson.fromJson(json, listType);
        }else {
        	listarUsuarios = new ArrayList<UsuariosVO>();
        }
		
		if (json != null) {
			Type listType = new TypeToken<ArrayList<UsuariosVO>>() {
			}.getType();
			Gson gson = new Gson();
			listarUsuarios = gson.fromJson(json, listType);
		} else {
			listarUsuarios = new ArrayList<UsuariosVO>();
		}

	}

	public ArrayList<UsuariosVO> getListarUsuarios() {
		return listarUsuarios;
	}

	public void setListarUsuarios(ArrayList<UsuariosVO> listarUsuarios) {
		this.listarUsuarios = listarUsuarios;
	}

	@PostMapping("/usuario/eliminarUsuario")
	public String eliminarUsuario(Model model, UsuariosVO usuario) {
		UsuariosVO usr = usudao.consultarUsuario(usuario);
		usudao = new UsuariosDAO();
		if(usr != null) {
			model.addAttribute("cedula", usudao.eliminarUsuario(usuario));
			model.addAttribute("mensaje", "Datos del Usuario Borrados");

		}else {
			model.addAttribute("error", "C�dula Errada");
		
		}
		return "/usuario/eliminarUsuario";
	}


}
