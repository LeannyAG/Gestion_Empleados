package edu.umg.programacion2.proyecto.dao;


import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import edu.umg.programacion2.proyecto.modelo.Empleado;



public class EmpleadoDAO {

	
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_empleados?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "Leanny.19";

	
   
    
    public Empleado crear (Empleado empleado) throws SQLException {
    	String sql = "INSERT INTO empleados (nombres, departamento, salario, fecha_contratacion, activo, fecha_baja) VALUES (?,?,?,?,?,?)";
    	
    	
    	try (Connection conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
                PreparedStatement statement = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
    		
    		statement.setString(1, empleado.getNombres());
    		statement.setString(2, empleado.getDepartamento());
    		statement.setBigDecimal(3, empleado.getSalario());
    		statement.setDate(4,
                    Date.valueOf(empleado.getFechaContratacion()));
    		statement.setBoolean(5, empleado.getActivo());

    		if (empleado.getFechaBaja() != null) {
    		    statement.setTimestamp(6, Timestamp.valueOf(empleado.getFechaBaja()));
    		} else {
    		    statement.setNull(6, Types.TIMESTAMP);
    		    
    		    statement.executeUpdate();

    		    try (ResultSet rs = statement.getGeneratedKeys()) {
    		        if (rs.next()) {
    		            empleado.setId(rs.getInt(1));
    		        }
    		    }

    		   
    		}
    	}
		return empleado;

    }	





public List<Empleado> listarTodos() throws SQLException {

    java.util.List<Empleado> empleados = new ArrayList<>();

    String sql = "SELECT * FROM empleados";

    try (Connection conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
         PreparedStatement statement = conexion.prepareStatement(sql);
         ResultSet rs = statement.executeQuery()) {

    	
    	while (rs.next()) {

            Empleado empleado = new Empleado();

            empleado.setId(rs.getInt("id"));
            empleado.setNombres(rs.getString("nombres"));
            empleado.setDepartamento(rs.getString("departamento"));
            empleado.setSalario(rs.getBigDecimal("salario"));
            empleado.setFechaContratacion(
                    rs.getDate("fecha_contratacion").toLocalDate()
            );
            empleado.setActivo(rs.getBoolean("activo"));

            Timestamp fechaBaja = rs.getTimestamp("fecha_baja");

            if (fechaBaja != null) {
                empleado.setFechaBaja(fechaBaja.toLocalDateTime());
            } else {
                empleado.setFechaBaja(null);
            }
    	
             empleados.add(empleado);
    }
    
}
return empleados;
}

         public boolean actualizar(Empleado empleado) throws SQLException {

    String sql = "UPDATE empleados SET nombres = ?, departamento = ?, "
            + "salario = ?, fecha_contratacion = ?, activo = ?, fecha_baja = ? "
            + "WHERE id = ?";

    try (Connection conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
         PreparedStatement statement = conexion.prepareStatement(sql)) {


    	statement.setString(1, empleado.getNombres());
		statement.setString(2, empleado.getDepartamento());
		statement.setBigDecimal(3, empleado.getSalario());
		statement.setDate(4,
                Date.valueOf(empleado.getFechaContratacion()));
		statement.setBoolean(5, empleado.getActivo());
		
		if (empleado.getFechaBaja() != null) {
           statement.setTimestamp(6, Timestamp.valueOf(empleado.getFechaBaja()));
        } else {
            statement.setNull(6, Types.TIMESTAMP);
            
        }
		
      statement.setInt(7, empleado.getId());
      
      return statement.executeUpdate() >=1;






}
    }
         
         
      public boolean eliminar (int id )  throws SQLException{
    	  String sql = "DELETE FROM empleados WHERE id = ?";
    	  
    	  try (Connection conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
    		         PreparedStatement statement = conexion.prepareStatement(sql)) {
    		  
    		  statement.setInt(1, id);
    		  
    		  return statement.executeUpdate() >= 1;
    	  }
    	  
      }
      
      
      
      public Optional<Empleado> buscarPorId(int id) throws SQLException {

    	    String sql = "SELECT * FROM empleados WHERE id = ?";

    	    try (Connection conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
    	         PreparedStatement statement = conexion.prepareStatement(sql)) {

    	        statement.setInt(1, id);

    	        try (ResultSet resultado = statement.executeQuery()) {

    	            if (resultado.next()) {

    	                Empleado empleado = new Empleado();

    	                empleado.setId(resultado.getInt("id"));
    	                empleado.setNombres(resultado.getString("nombres"));
    	                empleado.setDepartamento(resultado.getString("departamento"));
    	                empleado.setSalario(resultado.getBigDecimal("salario"));
    	                empleado.setFechaContratacion(
    	                        resultado.getDate("fecha_contratacion").toLocalDate()
    	                );
    	                empleado.setActivo(resultado.getBoolean("activo"));

    	                Timestamp fechaBaja = resultado.getTimestamp("fecha_baja");

    	                if (fechaBaja != null) {
    	                    empleado.setFechaBaja(fechaBaja.toLocalDateTime());
    	                } else {
    	                    empleado.setFechaBaja(null);
    	                }

    	                return Optional.of(empleado);
    	            }

    	            return Optional.empty();
    	        }
    	    }
    	}
      
         
      
}
