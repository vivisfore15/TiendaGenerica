package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class DetalleVentaDAO {
	PreparedStatement ps=null;
	ResultSet res=null;
	Conexion con= new Conexion();
	Connection cnn=con.Conecta();

	
	public boolean Inserta_Cliente(DetalleVentaDTO det){

		boolean resultado=false;
		//ClienteDTO usu=null;
		try{
		//usu=  buscarcliente(u);
		//if(usu!=null) {
			JOptionPane.showMessageDialog(null, "El Usuario ya existe...");
		//}else {
	    ps =cnn.prepareStatement("Insert Into(codigo_detalle,cantidad_producto,codigo_producto,codigo_venta_venta,valor_venta,valor_iva, valor-total) detalle_ventas value(?,?,?,?,?,?)");
		ps.setLong(1, det.getCantidadproducto());
		ps.setLong(2, det.getCodigoproducto());
		ps.setDouble(3, det.getCodigoventa());
		ps.setDouble(4, det.getValorventa());
		ps.setDouble(5, det.getValoriva());
		ps.setDouble(6, det.getValortotal());
		resultado=ps.executeUpdate()>0;
		//}
		}catch(SQLException ex){
		 JOptionPane.showMessageDialog(null, "Error al Insertar" +ex);
		}
		return resultado;
		}  	
	
}
