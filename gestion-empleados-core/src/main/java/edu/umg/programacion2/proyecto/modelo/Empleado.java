package edu.umg.programacion2.proyecto.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Empleado {
	
	
	private int id;
	private String nombres;
	private String departamento;
	private BigDecimal salario;
	private LocalDate fechaContratacion;
	private Boolean activo;
	private LocalDateTime fechaBaja;
	private String correo;
	

	  public Empleado() {
	    }


public Empleado (int id, String nombres, String departamento,BigDecimal salario, Boolean activo, LocalDateTime fechaBaja, LocalDate fechaContratacion, String correo ) {
    this.id = id;
    this.nombres = nombres;
    this.departamento = departamento;
    this.salario = salario;
    this.fechaContratacion = fechaContratacion;
    this.activo = activo;
    this.fechaBaja = fechaBaja;
    this.correo = correo;

}





public int getId() {
	return id;
}





public void setId(int id) {
	this.id = id;
}





public String getNombres() {
	return nombres;
}





public void setNombres(String nombres) {
	this.nombres = nombres;
}





public String getDepartamento() {
	return departamento;
}





public void setDepartamento(String departamento) {
	this.departamento = departamento;
}





public BigDecimal getSalario() {
	return salario;
}





public void setSalario(BigDecimal salario) {
	this.salario = salario;
}





public LocalDate getFechaContratacion() {
	return fechaContratacion;
}





public void setFechaContratacion(LocalDate fechaContratacion) {
	this.fechaContratacion = fechaContratacion;
}





public Boolean getActivo() {
	return activo;
}





public void setActivo(Boolean activo) {
	this.activo = activo;
}





public LocalDateTime getFechaBaja() {
	return fechaBaja;
}





public void setFechaBaja(LocalDateTime fechaBaja) {
	this.fechaBaja = fechaBaja;
}


public String getCorreo() {
	return correo;
}


public void setCorreo(String correo) {
	this.correo = correo;
}



























}




