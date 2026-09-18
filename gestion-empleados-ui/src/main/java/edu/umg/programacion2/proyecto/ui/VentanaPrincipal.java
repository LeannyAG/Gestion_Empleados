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

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import edu.umg.programacion2.proyecto.dao.EmpleadoDAO;
import edu.umg.programacion2.proyecto.modelo.Empleado;

public class VentanaPrincipal extends JFrame {

	private EmpleadoDAO empleadoDAO = new EmpleadoDAO();
	
	
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTable table_1;
	
	
	
	private void cargarEmpleados() {
		
		try {
			List<Empleado> empleados = empleadoDAO.listarTodos(); 
			
			DefaultTableModel modelo = 
					(DefaultTableModel) table.getModel();
			
			modelo.setRowCount(0);
			
			for(Empleado empleado : empleados) {
				
				modelo.addRow (new Object[] {
						empleado.getId(),
						empleado.getNombres(),
						empleado.getDepartamento(),
						empleado.getSalario(),
						empleado.getActivo() ? "si" : "no"
						
				});
			}
			}catch (SQLException e) {
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
        lblNewLabel_1_1.setBounds(165, 110, 129, 37);
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
        comboBox.setBounds(332, 121, 185, 20);
        getContentPane().add(comboBox);
        
        JLabel lblNewLabel_2 = new JLabel("AAAA-MM-DD");
        lblNewLabel_2.setBounds(501, 224, 90, 13);
        getContentPane().add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Datos del Empleado");
        lblNewLabel_3.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
        lblNewLabel_3.setBounds(372, 39, 123, 13);
        getContentPane().add(lblNewLabel_3);
        
        JButton btnregistrar = new JButton("Registar");
        btnregistrar.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
        btnregistrar.setBounds(204, 324, 90, 20);
        getContentPane().add(btnregistrar);
        
        JButton btnactualizar = new JButton("Actualizar");
        btnactualizar.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
        btnactualizar.setBounds(332, 325, 90, 20);
        getContentPane().add(btnactualizar);
        
        JButton btneliminar = new JButton("Eliminar");
        btneliminar.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
        btneliminar.setBounds(457, 326, 90, 20);
        getContentPane().add(btneliminar);
        
        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
        btnLimpiar.setBounds(585, 325, 90, 20);
        getContentPane().add(btnLimpiar);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(123, 381, 612, 156);
        getContentPane().add(scrollPane);

        table = new JTable();

        table.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] {
                        "ID", "Nombre", "Departamento", "Salario", "Activo"
                }
        ));

        scrollPane.setViewportView(table);
        
        
        cargarEmpleados();
    }
    

    
    }


