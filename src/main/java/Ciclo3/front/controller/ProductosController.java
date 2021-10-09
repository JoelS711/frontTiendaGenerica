package Ciclo3.front.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import Ciclo3.front.CSVHelper;
import Ciclo3.front.model.ProductosDAO;
import Ciclo3.front.vo.ProductosVO;

@Controller
public class ProductosController {

	@Autowired
	private ProductosDAO miDao;

	

	@PostMapping("/producto/cargarProducto")
	public String uploadFile(Model model, MultipartFile file) throws IOException {
		try {
			List<ProductosVO> misP = new ArrayList<ProductosVO>();
			List<String[]> datos = CSVHelper.csvToTutorials(file.getInputStream());
			ProductosVO p;
			for (String[] s : datos) {
				StringTokenizer token = new StringTokenizer(s[0], ";");
				String[] tok = new String[6];
				int i = 0;
				while (token.hasMoreTokens()) {
					tok[i] = token.nextToken();
					i++;
				}

				p = new ProductosVO(Integer.parseInt(tok[0]), Long.parseLong(tok[1]), Float.parseFloat(tok[2]), tok[3],
						Float.parseFloat(tok[4]), Float.parseFloat(tok[5]));
				misP.add(p);
			}
			miDao = new ProductosDAO();
			miDao.borrarProductos();
			for (ProductosVO prod : misP) {
				ProductosVO pRec = miDao.nuevoProducto(prod);
				if (pRec != null) {
					model.addAttribute("cargaArchivo", "Productos Guardados");
				} else {
					model.addAttribute("errorCargaArchivo", "No se pudo guardar el producto");
					break;
				}
			}
			// repository.saveAll(tutorials);
		} catch (IOException e) {
			throw new RuntimeException("fail to store csv data: " + e.getMessage());
		}
		// model.addAttribute("message", "File: has been uploaded successfully!");
		return "/producto/cargarProducto";
	}

	@GetMapping("/producto/borrarProductos")
	public void borrarProductos() {
		 miDao = new ProductosDAO();
		miDao.borrarProductos();

	}
}
