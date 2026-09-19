package edu.umg.programacion2.proyecto.ui;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import edu.umg.programacion2.proyecto.dao.EmpleadoDAO;
import edu.umg.programacion2.proyecto.modelo.Empleado;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class VentanaPrincipal extends JFrame {

	private EmpleadoDAO empleadoDAO = new EmpleadoDAO();
	
	
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTable table_1;
	private JTextField textField_1;
	
	
	
	private void cargarEmpleados() {
		
		try {
			List<Empleado> empleados = empleadoDAO.listarTodos(); 
			
			DefaultTableModel modelo = 
					
					(DefaultTableModel) table.getModel();
			
			
			modelo.setRowCount(0);
			
			for(Empleado empleado : empleados) {
				
				modelo.addRow(new Object[] {
					    empleado.getId(),
					    empleado.getNombres(),
					    empleado.getCorreo(),
					    empleado.getDepartamento(),
					    empleado.getSalario(),
					    empleado.getFechaContratacion(),
					    empleado.getActivo() ? "si" : "no"
					});
			}
			}catch (Exception e) {
			 JOptionPane.showMessageDialog(
					 this,
					 "Error al cargar los empleados" + e.getMessage(),
					 "ERROR",
					 JOptionPane.ERROR_MESSAGE
					 );
			}
		}
		
	

    public VentanaPrincipal() {
    	
    	setTitle("Gestión de Empleados");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("GESTION EMPLEADOS");
        lblNewLabel.setBounds(0, 0, 886, 30);
        lblNewLabel.setFont(new Font("HP Simplified", Font.BOLD, 25));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Nombres");
        lblNewLabel_1.setFont(new Font("HP Simplified Hans", Font.BOLD, 18));
        lblNewLabel_1.setBounds(165, 64, 90, 37);
        getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("Departamento");
        lblNewLabel_1_1.setFont(new Font("HP Simplified Hans", Font.BOLD, 18));
        lblNewLabel_1_1.setBounds(165, 127, 129, 37);
        getContentPane().add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Salario");
        lblNewLabel_1_1_1.setFont(new Font("HP Simplified Hans", Font.BOLD, 18));
        lblNewLabel_1_1_1.setBounds(165, 162, 129, 37);
        getContentPane().add(lblNewLabel_1_1_1);
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("Fecha Contratacion");
        lblNewLabel_1_1_1_1.setFont(new Font("HP Simplified Hans", Font.BOLD, 18));
        lblNewLabel_1_1_1_1.setBounds(165, 209, 185, 37);
        getContentPane().add(lblNewLabel_1_1_1_1);
        
        JCheckBox chckbxNewCheckBox = new JCheckBox("Activo");
        chckbxNewCheckBox.setFont(new Font("HP Simplified Hans", Font.BOLD, 18));
        chckbxNewCheckBox.setBounds(163, 269, 92, 20);
        getContentPane().add(chckbxNewCheckBox);
        
        textField = new JTextField();
        textField.setBounds(332, 76, 231, 18);
        getContentPane().add(textField);
        textField.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(332, 174, 170, 18);
        getContentPane().add(textField_2);
        textField_2.setColumns(10);
        
        textField_3 = new JTextField();
        textField_3.setBounds(332, 221, 163, 18);
        getContentPane().add(textField_3);
        textField_3.setColumns(10);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("HP Simplified Hans", Font.BOLD, 12));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Sistemas", "Ventas", "Contabilidad", "Administracion", "Marketing"}));
        comboBox.setBounds(334, 137, 185, 20);
        getContentPane().add(comboBox);
       
        
        JLabel lblNewLabel_2 = new JLabel("AAAA-MM-DD");
        lblNewLabel_2.setBounds(501, 224, 90, 13);
        getContentPane().add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Datos del Empleado");
        lblNewLabel_3.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
        lblNewLabel_3.setBounds(372, 39, 123, 13);
        getContentPane().add(lblNewLabel_3);
        
        JButton btnregistrar = new JButton("Registar");
        btnregistrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		try {
        			String nombres = textField.getText().trim();
        			String correo = textField_1.getText().trim();
        		    String departamento = comboBox.getSelectedItem().toString();
        		    BigDecimal salario = new BigDecimal(textField_2.getText().trim());
        		    LocalDate fecha = LocalDate.parse(textField_3.getText().trim());
        		    boolean activo = chckbxNewCheckBox.isSelected();
        		    
        		    if(nombres.isEmpty()) {
        		    	JOptionPane.showMessageDialog(
        		    			VentanaPrincipal.this,
        		    			"Debe ingresar el nombre"
        		    			);
        		    	return;
        		    	
        		    }
        		    
        		    if(salario.compareTo(BigDecimal.ZERO) <= 0) {
        		    	JOptionPane.showMessageDialog(
        		    			VentanaPrincipal.this,
        		    			"El salario debe ser mayor a 0"
        		    			);
        		    	return;
        		    	
        		    }
        		    
        		    if(fecha.isAfter(LocalDate.now())) {
        		    	JOptionPane.showMessageDialog(
        		    			VentanaPrincipal.this,
        		    			"La fecha de contratacion no puede ser futura"
        		    			);
        		    	return;
        		    }
        		    
        		    Empleado empleado = new Empleado();
        		    
        		    empleado.setNombres(nombres);
					empleado.setCorreo(correo);
        		    empleado.setDepartamento(departamento);
        		    empleado.setSalario(salario);
        		    empleado.setFechaContratacion(fecha);
        		    empleado.setActivo(activo);
        		    empleado.setFechaBaja(null);
        		    
        		    empleadoDAO.crear(empleado);
        		    
        		    JOptionPane.showMessageDialog(
        		            VentanaPrincipal.this,
        		            "Empleado registrado correctamente."
        		    );
        		    
        		    	cargarEmpleados();
        		    
        		} catch (NumberFormatException ex) {

        		    JOptionPane.showMessageDialog(
        		            VentanaPrincipal.this,
        		            "Ingrese un salario válido."
        		    );

        		} catch (DateTimeParseException ex) {

        		    JOptionPane.showMessageDialog(
        		            VentanaPrincipal.this,
        		            "La fecha debe escribirse como AAAA-MM-DD."
        		    );

        		} catch (Exception ex) {

        		    JOptionPane.showMessageDialog(
        		            VentanaPrincipal.this,
        		            "Error al registrar: " + ex.getMessage(),
        		            "ERROR",
        		            JOptionPane.ERROR_MESSAGE
        		    );
        		}
        		 if (comboBox.getSelectedIndex() == 0) {
        	            JOptionPane.showMessageDialog(
        	                VentanaPrincipal.this,
        	                "Debe seleccionar un departamento."
        	            );
        	            return;
        	        }
        		 
        		 
        		 
        	}
        });
       
        
        btnregistrar.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
        btnregistrar.setBounds(204, 324, 90, 20);
        getContentPane().add(btnregistrar);
        
        JButton btnactualizar = new JButton("Actualizar");
        btnactualizar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int fila = table.getSelectedRow();

        		if (fila == -1) {
        		    JOptionPane.showMessageDialog(
        		            VentanaPrincipal.this,
        		            "Debe seleccionar un empleado de la tabla."
        		    );
        		    return;
        		}

        		try {
        		    int id = Integer.parseInt(
        		            table.getValueAt(fila, 0).toString()
        		    );

        		    String nombres = textField.getText().trim();
        		    String correo  = textField_1.getText().trim();
        		    String departamento = comboBox.getSelectedItem().toString();
        		    BigDecimal salario = new BigDecimal(textField_2.getText().trim());
        		    LocalDate fecha = LocalDate.parse(textField_3.getText().trim());
        		    boolean activo = chckbxNewCheckBox.isSelected();

        		    if (nombres.isEmpty()) {
        		        JOptionPane.showMessageDialog(
        		                VentanaPrincipal.this,
        		                "Debe ingresar el nombre."
        		        );
        		        return;
        		    }

        		    if (comboBox.getSelectedIndex() == 0) {
        		        JOptionPane.showMessageDialog(
        		                VentanaPrincipal.this,
        		                "Debe seleccionar un departamento."
        		        );
        		        return;
        		    }

        		    if (salario.compareTo(BigDecimal.ZERO) <= 0) {
        		        JOptionPane.showMessageDialog(
        		                VentanaPrincipal.this,
        		                "El salario debe ser mayor a 0."
        		        );
        		        return;
        		    }

        		    if (fecha.isAfter(LocalDate.now())) {
        		        JOptionPane.showMessageDialog(
        		                VentanaPrincipal.this,
        		                "La fecha de contratación no puede ser futura."
        		        );
        		        return;
        		    }

        		    Empleado empleado = new Empleado();

        		    empleado.setId(id);
        		    empleado.setNombres(nombres);
        		    empleado.setCorreo(correo);
        		    empleado.setDepartamento(departamento);
        		    empleado.setSalario(salario);
        		    empleado.setFechaContratacion(fecha);
        		    empleado.setActivo(activo);
        		    empleado.setFechaBaja(null);

        		    boolean actualizado = empleadoDAO.actualizar(empleado);

        		    if (actualizado) {
        		        JOptionPane.showMessageDialog(
        		                VentanaPrincipal.this,
        		                "Empleado actualizado correctamente."
        		        );

        		        cargarEmpleados();

        		    } else {
        		        JOptionPane.showMessageDialog(
        		                VentanaPrincipal.this,
        		                "No se encontró el empleado."
        		        );
        		    }

        		} catch (NumberFormatException ex) {

        		    JOptionPane.showMessageDialog(
        		            VentanaPrincipal.this,
        		            "Ingrese un salario válido."
        		    );

        		} catch (DateTimeParseException ex) {

        		    JOptionPane.showMessageDialog(
        		            VentanaPrincipal.this,
        		            "La fecha debe escribirse como AAAA-MM-DD."
        		    );

        		} catch (Exception ex) {

        		    JOptionPane.showMessageDialog(
        		            VentanaPrincipal.this,
        		            "Error al actualizar: " + ex.getMessage(),
        		            "ERROR",
        		            JOptionPane.ERROR_MESSAGE
        		    );
        		}
        	}
        });
        btnactualizar.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
        btnactualizar.setBounds(332, 325, 90, 20);
        getContentPane().add(btnactualizar);
        
        JButton btneliminar = new JButton("Eliminar");
        btneliminar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int fila = table.getSelectedRow();

        		if (fila == -1) {
        		    JOptionPane.showMessageDialog(
        		            VentanaPrincipal.this,
        		            "Debe seleccionar un empleado de la tabla."
        		    );
        		    return;
        		}

        		int id = Integer.parseInt(
        		        table.getValueAt(fila, 0).toString()
        		);

        		String nombre = table.getValueAt(fila, 1).toString();

        		int respuesta = JOptionPane.showConfirmDialog(
        		        VentanaPrincipal.this,
        		        "¿Está seguro de eliminar a " + nombre + "?",
        		        "Confirmar eliminación",
        		        JOptionPane.YES_NO_OPTION
        		);

        		if (respuesta == JOptionPane.YES_OPTION) {

        		    try {

        		        boolean eliminado = empleadoDAO.eliminar(id);

        		        if (eliminado) {

        		            JOptionPane.showMessageDialog(
        		                    VentanaPrincipal.this,
        		                    "Empleado eliminado correctamente."
        		            );

        		            cargarEmpleados();

        		            textField.setText("");
        		            textField_1.setText("");
        		            comboBox.setSelectedIndex(0);
        		            textField_2.setText("");
        		            textField_3.setText("");
        		            chckbxNewCheckBox.setSelected(true);
        		            table.clearSelection();

        		        } else {

        		            JOptionPane.showMessageDialog(
        		                    VentanaPrincipal.this,
        		                    "No se encontró el empleado."
        		            );
        		        }

        		    } catch (Exception ex) {

        		        JOptionPane.showMessageDialog(
        		                VentanaPrincipal.this,
        		                "Error al eliminar: " + ex.getMessage(),
        		                "ERROR",
        		                JOptionPane.ERROR_MESSAGE
        		        );
        		    }
        		}
        	}
        });
        btneliminar.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
        btneliminar.setBounds(457, 326, 90, 20);
        getContentPane().add(btneliminar);
        
        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		textField.setText("");
        		textField_1.setText("");
        		comboBox.setSelectedIndex(0);
        		textField_2.setText("");
        		textField_3.setText("");
        		chckbxNewCheckBox.setSelected(true);
        		table.clearSelection();
        	}
        });
        btnLimpiar.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
        btnLimpiar.setBounds(585, 325, 90, 20);
        getContentPane().add(btnLimpiar);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(123, 381, 612, 89);
        getContentPane().add(scrollPane);

        table = new JTable();

        table.setModel(new DefaultTableModel(
        	    new Object[][] {},
        	    new String[] {
        	        "ID",
        	        "Nombre",
        	        "Correo",
        	        "Departamento",
        	        "Salario",
        	        "Fecha Contratación",
        	        "Activo"
        	    }
        	));

        scrollPane.setViewportView(table);
        
        JLabel lblNewLabel_1_1_2 = new JLabel("Correo electronico");
        lblNewLabel_1_1_2.setFont(new Font("HP Simplified Hans", Font.BOLD, 18));
        lblNewLabel_1_1_2.setBounds(163, 97, 150, 37);
        getContentPane().add(lblNewLabel_1_1_2);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(332, 109, 191, 18);
        getContentPane().add(textField_1);
        
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int fila = table.getSelectedRow();

                if (fila >= 0) {

                    textField.setText(
                            table.getValueAt(fila, 1).toString()
                    );
                    
                    Object  correo = table.getValueAt(fila, 2);
                    
                    textField_1.setText(
                           correo != null ? correo.toString() : ""
                    );

                    comboBox.setSelectedItem(
                            table.getValueAt(fila, 3).toString()
                    );

                    textField_2.setText(
                            table.getValueAt(fila, 4).toString()
                    );

                    textField_3.setText(
                            table.getValueAt(fila, 6).toString()
                    );

                    String activo = table.getValueAt(fila, 6).toString();

                    chckbxNewCheckBox.setSelected(
                            activo.equalsIgnoreCase("si")
                    );
                }
            }
        });
        
        
        cargarEmpleados();
    }
    

    
    }


