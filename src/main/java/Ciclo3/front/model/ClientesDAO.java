package Ciclo3.front.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import Ciclo3.front.vo.ClientesVO;
import reactor.core.publisher.Mono;


@Service
public class ClientesDAO {

private static final String URL = "http://localhost:8080";
	
	@Autowired
	private WebClient webClient;
	
	public ClientesVO actualizarCliente(ClientesVO cli) {

		try {
			WebClient webClient = WebClient.create(URL);
			ClientesVO objCliente = null;
			Mono<ClientesVO> response = webClient.post().uri(URL + "/cliente/actualizarCliente")
					.body(Mono.just(cli), ClientesVO.class).retrieve().bodyToMono(ClientesVO.class);

			objCliente = response.block();
			return objCliente;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}

	}
	public ClientesVO eliminarCliente(ClientesVO cli) {

		try {
			WebClient webClient = WebClient.create(URL);
			ClientesVO objCliente = null;
			Mono<ClientesVO> response = webClient.post().uri(URL + "/cliente/eliminarCliente")
					.body(Mono.just(cli), ClientesVO.class).retrieve().bodyToMono(ClientesVO.class);

			objCliente = response.block();
			return objCliente;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}
	}
	public ClientesVO consultarCliente(ClientesVO cli) {

		try {
			WebClient webClient = WebClient.create(URL);
			ClientesVO objCli = null;
			Mono<ClientesVO> response = webClient.post().uri(URL + "/cliente/consultarCliente")
					.body(Mono.just(cli), ClientesVO.class).retrieve().bodyToMono(ClientesVO.class);

			objCli = response.block();
			return objCli;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}

	}
	
public String listarClientes() {
		
		try {

            URL url = new URL(URL+"/listarClientes");//your url i.e fetch data from .
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

public ClientesVO crearCliente(ClientesVO cli) {

	try {
		WebClient webClient = WebClient.create(URL);
		ClientesVO objCliente = null;
		Mono<ClientesVO> response = webClient.post().uri(URL + "/cliente/crearCliente")
				.body(Mono.just(cli), ClientesVO.class).retrieve().bodyToMono(ClientesVO.class);

		objCliente = response.block();
		return objCliente;

	} catch (WebClientResponseException e) {
		e.getMessage();
		System.out.println("---->" + e.getMessage());
		return null;
	}

}

}
