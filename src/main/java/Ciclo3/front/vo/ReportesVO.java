package Ciclo3.front.vo;

public class ReportesVO {

	Long cedula;
	String nombre;
	Float total;
	
	
	
	public ReportesVO(Long cedula, String nombre, Float total) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.total = total;
	}
	public Long getCedula() {
		return cedula;
	}
	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	
	
}
