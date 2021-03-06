package Ciclo3.front.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import Ciclo3.front.vo.UsuariosVO;
import reactor.core.publisher.Mono;

@Service
public class UsuariosDAO {
private static final String URL = "http://localhost:8080";
	
	@Autowired
	private WebClient webClient;
	
	public UsuariosVO auth(UsuariosVO usr) {
		WebClient webClient =  WebClient.create(URL);
		UsuariosVO objUsuario = null;
		
		Mono<UsuariosVO> response = webClient.post().uri(URL+"/auth").
				body(Mono.just(usr),UsuariosVO.class).retrieve().bodyToMono(UsuariosVO.class);
		objUsuario = response.block();
		
		return objUsuario;
	}
	
public String listarUsuarios() {
		
		try {

            URL url = new URL(URL+"/listarUsuarios");//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String json = br.readLine();
            conn.disconnect();
            return json;
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
		return null;
	}

public UsuariosVO crearUsuario(UsuariosVO usr) {

	try {
		WebClient webClient = WebClient.create(URL);
		UsuariosVO objUsuario = null;
		Mono<UsuariosVO> response = webClient.post().uri(URL + "/usuario/crearUsuario")
				.body(Mono.just(usr), UsuariosVO.class).retrieve().bodyToMono(UsuariosVO.class);

		objUsuario = response.block();
		return objUsuario;

	} catch (WebClientResponseException e) {
		e.getMessage();
		System.out.println("---->" + e.getMessage());
		return null;
	}

}

public UsuariosVO actualizarUsuario(UsuariosVO usr) {

	try {
		WebClient webClient = WebClient.create(URL);
		UsuariosVO objUsuario = null;
		Mono<UsuariosVO> response = webClient.post().uri(URL + "/usuario/actualizarUsuario")
				.body(Mono.just(usr), UsuariosVO.class).retrieve().bodyToMono(UsuariosVO.class);

		objUsuario = response.block();
		return objUsuario;

	} catch (WebClientResponseException e) {
		e.getMessage();
		System.out.println("---->" + e.getMessage());
		return null;
	}

}

public UsuariosVO consultarUsuario(UsuariosVO usr) {

	try {
		WebClient webClient = WebClient.create(URL);
		UsuariosVO objUsuario = null;
		Mono<UsuariosVO> response = webClient.post().uri(URL + "/usuario/consultarUsuario")
				.body(Mono.just(usr), UsuariosVO.class).retrieve().bodyToMono(UsuariosVO.class);

		objUsuario = response.block();
		return objUsuario;

	} catch (WebClientResponseException e) {
		e.getMessage();
		System.out.println("---->" + e.getMessage());
		return null;
	}

}
public UsuariosVO eliminarUsuario(UsuariosVO usr) {

	try {
		WebClient webClient = WebClient.create(URL);
		UsuariosVO objUsuario = null;
		Mono<UsuariosVO> response = webClient.post().uri(URL + "/usuario/eliminarUsuario")
				.body(Mono.just(usr), UsuariosVO.class).retrieve().bodyToMono(UsuariosVO.class);

		objUsuario = response.block();
		return objUsuario;

	} catch (WebClientResponseException e) {
		e.getMessage();
		System.out.println("---->" + e.getMessage());
		return null;
	}
}
}
