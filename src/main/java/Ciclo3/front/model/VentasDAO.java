package Ciclo3.front.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import Ciclo3.front.vo.VentasVO;
import reactor.core.publisher.Mono;

@Service
public class VentasDAO {
private static final String URL = "http://localhost:8080";
	
@Autowired
private WebClient webClient;

public VentasVO crearVenta(VentasVO ven) {

	try {
		WebClient webClient = WebClient.create(URL);
		VentasVO objVenta = null;
		Mono<VentasVO> response = webClient.post().uri(URL + "/usuario/crearUsuario")
				.body(Mono.just(ven), VentasVO.class).retrieve().bodyToMono(VentasVO.class);

		objVenta = response.block();
		return objVenta;

	} catch (WebClientResponseException e) {
		e.getMessage();
		System.out.println("---->" + e.getMessage());
		return null;
	}

}

public String listarVentas() {
	
	try {

        URL url = new URL(URL+"/reportes/listarVentas");//your url i.e fetch data from .
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

}