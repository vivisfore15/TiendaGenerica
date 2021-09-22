package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class ClienteDAO {
	PreparedStatement ps=null;
	ResultSet res=null;
	Conexion con= new Conexion();
	Connection conecta=con.Conecta();

	
	public boolean Inserta_Cliente(ClienteDTO u){

		boolean resultado=false;
		ClienteDTO usu=null;
		try{
		usu=  buscarcliente(u);
		if(usu!=null) {
			JOptionPane.showMessageDialog(null, "El Usuario ya existe...");
		}else {
		String sql="Insert Into clientes value(?,?,?,?,?)";
		ps =conecta.prepareStatement(sql);
		ps.setLong(1, u.getCedula());
		ps.setString(2, u.getDireccion());
		ps.setString(3, u.getEmail());
		ps.setString(4, u.getNombre());
		ps.setString(5, u.getTelefono());
		resultado=ps.executeUpdate()>0;
		}
		}catch(SQLException ex){
		 JOptionPane.showMessageDialog(null, "Error al Insertar" +ex);
		}
		return resultado;
		}  
	
    public ClienteDTO buscarcliente(ClienteDTO cli){

    ClienteDTO u=null;
    
    try{
    String sql="select * from clientes where cedula_usuario=?";
    ps =conecta.prepareStatement(sql);
    ps.setLong(1, cli.getCedula());
    res=ps.executeQuery();
    
    while(res.next()){

       u= new ClienteDTO(res.getLong(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));

     }
    }catch(SQLException ex){
     JOptionPane.showMessageDialog(null,"Error al Consultar" +ex);
    }
    return u;
    }
    
    public boolean eliminarcliente(ClienteDTO cli) {
		int x;
		boolean dat=false;
		try {
			ps=conecta.prepareStatement("DELETE FROM clientes WHERE documento=?");
			ps.setLong(1,cli.getCedula() );
			x=ps.executeUpdate();
			
			if(x>0) {
			dat=true;	
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return dat;
	}
    
    public int actulizar(ClienteDTO cli) {
		int x=0;
	  try {
		ps=conecta.prepareStatement("UPDATE clientes Set direccion_cliente=?,email_cliente=?,nombre_cliente=?,	telefono_cliente=? WHERE cedula_cliente=?");
		ps.setString(1, cli.getDireccion());
		ps.setString(2,cli.getEmail());
		ps.setString(3, cli.getNombre());
		ps.setString(4, cli.getTelefono());
		ps.setString(5, cli.getTelefono());
		x= ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  return x;
	}
    
    
    
	
}
