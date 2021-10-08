package Ciclo3.front.model;

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
}
