package Ciclo3.front.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import Ciclo3.front.vo.ProductosVO;
import reactor.core.publisher.Mono;



@Service
public class ProductosDAO {

private static final String URL = "http://localhost:8080";
	
	@Autowired
	private WebClient webClient;
	
	public ProductosVO nuevoProducto(ProductosVO p) {
		WebClient webClient =  WebClient.create(URL);
		ProductosVO objProducto = null;
		
		Mono<ProductosVO> response = webClient.put().uri(URL+"/producto/registrarProducto").
				body(Mono.just(p),ProductosVO.class).retrieve().bodyToMono(ProductosVO.class);
		objProducto = response.block();
		return objProducto;
	}

	public void borrarProductos() {
		try {

	        URL url = new URL(URL+"/producto/borrarProductos");//your url i.e fetch data from .
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
	        //return json;
	    } catch (Exception e) {
	        System.out.println("Exception in NetClientGet:- " + e);
	    }
		//return null;
		
	}
}
