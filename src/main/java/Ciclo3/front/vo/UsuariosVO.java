package Ciclo3.front.vo;

public class UsuariosVO {
	Long cedula;
	String nombre;
	String correo;
	String usuario;
	String contrasena;





	public UsuariosVO(Long cedula, String nombre, String correo, String usuario, String contrasena) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.correo = correo;
		this.usuario = usuario;
		this.contrasena = contrasena;
	}





	public UsuariosVO() {
		super();
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





	public String getCorreo() {
		return correo;
	}





	public void setCorreo(String correo) {
		this.correo = correo;
	}





	public String getUsuario() {
		return usuario;
	}





	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}





	public String getContrasena() {
		return contrasena;
	}





	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}





	@Override
	public String toString() {
		return "UsuariosVO [cedula=" + cedula + ", nombre=" + nombre + ", correo=" + correo + ", usuario=" + usuario + ", contrasena=" + contrasena
				+ "]";
	}
}
