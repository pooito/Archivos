package ito.poo.clases;

import java.time.LocalDate;

public class Producto {

	private int id;
	private String descripcion;
	private float precio;
	private int existencias;
    private LocalDate actualizacion;
	
    public Producto() {
    	
    }
    
	public Producto(int id, String descripcion, float precio, int existencias, LocalDate actualizacion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
		this.existencias = existencias;
		this.actualizacion = actualizacion;
	}
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getExistencias() {
		return existencias;
	}
	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}
	public LocalDate getActualizacion() {
		return actualizacion;
	}
	public void setActualizacion(LocalDate actualizacion) {
		this.actualizacion = actualizacion;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", descripcion=" + descripcion + ", precio=" + precio + ", existencias="
				+ existencias + ", actualizacion=" + actualizacion + "]";
	}
    
    
	

}
