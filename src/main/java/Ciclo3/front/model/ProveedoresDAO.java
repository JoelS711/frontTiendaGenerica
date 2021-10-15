package Ciclo3.front.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import Ciclo3.front.vo.ProveedoresVO;
import Ciclo3.front.vo.UsuariosVO;
import reactor.core.publisher.Mono;

import Ciclo3.front.vo.ProveedoresVO;

@Service
public class ProveedoresDAO {
	private static final String URL = "http://localhost:8080";
	
	@Autowired
	private WebClient webClient;
	
	
	
public String listarProveedores() {
		
		try {

            URL url = new URL(URL+"/listarProveedores");//your url i.e fetch data from .
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

public ProveedoresVO crearProveedor(ProveedoresVO pro) {

	try {
		WebClient webClient = WebClient.create(URL);
		ProveedoresVO objProveedor = null;
		Mono<ProveedoresVO> response = webClient.post().uri(URL + "/proveedor/crearProveedor")
				.body(Mono.just(pro), ProveedoresVO.class).retrieve().bodyToMono(ProveedoresVO.class);

		objProveedor = response.block();
		return objProveedor;

	} catch (WebClientResponseException e) {
		e.getMessage();
		System.out.println("---->" + e.getMessage());
		return null;
	}

}

public ProveedoresVO actualizarProveedor(ProveedoresVO pro) {

	try {
		WebClient webClient = WebClient.create(URL);
		ProveedoresVO objProveedor = null;
		Mono<ProveedoresVO> response = webClient.post().uri(URL + "/proveedor/actualizarProveedor")
				.body(Mono.just(pro), ProveedoresVO.class).retrieve().bodyToMono(ProveedoresVO.class);

		objProveedor = response.block();
		return objProveedor;

	} catch (WebClientResponseException e) {
		e.getMessage();
		System.out.println("---->" + e.getMessage());
		return null;
	}

}

public ProveedoresVO consultarProveedor(ProveedoresVO pro) {

	try {
		WebClient webClient = WebClient.create(URL);
		ProveedoresVO objProveedor = null;
		Mono<ProveedoresVO> response = webClient.post().uri(URL + "/proveedor/consultarProveedor")
				.body(Mono.just(pro), ProveedoresVO.class).retrieve().bodyToMono(ProveedoresVO.class);

		objProveedor = response.block();
		return objProveedor;

	} catch (WebClientResponseException e) {
		e.getMessage();
		System.out.println("---->" + e.getMessage());
		return null;
	}

}

public ProveedoresVO eliminarProveedor(ProveedoresVO pro) {

	try {
		WebClient webClient = WebClient.create(URL);
		ProveedoresVO objProveedor = null;
		Mono<ProveedoresVO> response = webClient.post().uri(URL + "/proveedor/eliminarProveedor")
				.body(Mono.just(pro), ProveedoresVO.class).retrieve().bodyToMono(ProveedoresVO.class);

		objProveedor = response.block();
		return objProveedor;

	} catch (WebClientResponseException e) {
		e.getMessage();
		System.out.println("---->" + e.getMessage());
		return null;
	}

}
}
