package Ciclo3.front.vo;

import javax.validation.constraints.NotBlank;

public class ProveedoresVO {
	
	
	Long nit;
	@NotBlank
	String ciudad;
	@NotBlank
	String direccion;
	@NotBlank
	String nombre;
	@NotBlank
	String telefono;
	
	public ProveedoresVO(Long nit, String ciudad, String direccion, String nombre, String telefono) {
		super();
		this.nit = nit;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	
	
	public ProveedoresVO() {
		super();
	}



	public Long getNit() {
		return nit;
	}
	public void setNit(Long nit) {
		this.nit = nit;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	@Override
	public String toString() {
		return "ProveedoresVO [nit=" + nit + ", ciudad=" + ciudad + ", direccion=" + direccion + ", nombre=" + nombre
				+ ", telefono=" + telefono + "]";
	}
	
}
