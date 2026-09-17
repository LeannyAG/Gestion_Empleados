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

import edu.umg.programacion2.proyecto.modelo.Empleado;



public class EmpleadoDAO {

	
    private static final String URL = "jdbc:mysql://localhost:3306/gestion-empleados?useSSL=false&serverTimezone=UTC";
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
}
