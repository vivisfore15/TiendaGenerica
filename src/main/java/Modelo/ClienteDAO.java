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
    
    public int actulizar(Usuarios_DTO usdto) {
		int x=0;
	  try {
		ps=conecta.prepareStatement("UPDATE clientes Set nomusu=?,clave=?,rol=?,estado=? WHERE documento=?");
		ps.setString(1, usdto.getNombre_Usuario());
		ps.setString(2,usdto.getEmail_Usuario());
		ps.setString(3, usdto.getPassword());
		ps.setString(4, usdto.getUsuario());
		ps.setLong(5, usdto.getCedula_Usuario());
		x= ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  return x;
	}
    
    
    
	
}
