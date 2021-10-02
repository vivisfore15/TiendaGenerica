package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class VentasDAO {
	PreparedStatement ps=null;
	ResultSet res=null;
	Conexion con= new Conexion();
	Connection cnn=con.Conecta();

	
	public boolean insertarventa(VentasDTO ven){
		

		boolean resultado=false;
		
		try{
		
			
		
	    ps =cnn.prepareStatement("Insert Into ventas(cedula_cliente,cedula_usuario,iva_venta,total_venta,valor_venta) value(?,?,?,?,?)");
		ps.setLong(1, ven.getCedula());
		ps.setLong(2, ven.getCedula_Usuario());
		ps.setDouble(3, ven.getIvaventa());
		ps.setDouble(4, ven.getTotalventa());
		ps.setDouble(5, ven.getValorventa());
		resultado=ps.executeUpdate()>0;
		
		}catch(SQLException ex){
		 JOptionPane.showMessageDialog(null, "Error al Insertar" +ex);
		}
		return resultado;
		}  	
	

}
