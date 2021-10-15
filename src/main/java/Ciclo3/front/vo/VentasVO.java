package Ciclo3.front.vo;

public class VentasVO {
	
	private Long cedula_usuario;
	private Long cedula_cliente;
	private Long codigo;
	private Long iva;
	private Long total_venta;
	private Long valor_venta;
	
	public VentasVO(Long cedula_usuario, Long cedula_cliente, Long codigo, Long iva, Long total_venta,
			Long valor_venta) {
		super();
		this.cedula_usuario = cedula_usuario;
		this.cedula_cliente = cedula_cliente;
		this.codigo = codigo;
		this.iva = iva;
		this.total_venta = total_venta;
		this.valor_venta = valor_venta;
	}

	@Override
	public String toString() {
		return "VentasVO [cedula_usuario=" + cedula_usuario + ", cedula_cliente=" + cedula_cliente + ", codigo="
				+ codigo + ", iva=" + iva + ", total_venta=" + total_venta + ", valor_venta=" + valor_venta + "]";
	}

	public Long getCedula_usuario() {
		return cedula_usuario;
	}

	public void setCedula_usuario(Long cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}

	public Long getCedula_cliente() {
		return cedula_cliente;
	}

	public void setCedula_cliente(Long cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getIva() {
		return iva;
	}

	public void setIva(Long iva) {
		this.iva = iva;
	}

	public Long getTotal_venta() {
		return total_venta;
	}

	public void setTotal_venta(Long total_venta) {
		this.total_venta = total_venta;
	}

	public Long getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(Long valor_venta) {
		this.valor_venta = valor_venta;
	}
	

}