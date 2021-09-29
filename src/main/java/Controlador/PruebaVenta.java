package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import Modelo.ClienteDAO;
import Modelo.ClienteDTO;
import Modelo.PoductosDTO;
import Modelo.ProductosDAO;

/**
 * Servlet implementation class PruebaVenta
 */
@WebServlet("/PruebaVenta")
public class PruebaVenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PruebaVenta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion=request.getSession();
		if(request.getParameter("confirmar")!=null) {
		long cedula,ced;
		String nom;
		
		
		ClienteDTO listado;
		cedula=Long.parseLong(request.getParameter("cedula"));
		ClienteDAO clidao=new ClienteDAO();
		ClienteDTO clidto=new ClienteDTO(cedula);
		listado=clidao.consultarcliente(clidto);
		
		//ced=listadto.getCedula();
		//nom=listadto.getNombre();
		 sesion.setAttribute("cliente",listado);
		 ///request.setAttribute("clientenombre",nom);
		//JOptionPane.showMessageDialog(null, ced+nom);
		 request.getRequestDispatcher("ventas.jsp").forward(request, response);
		}
		
		
		
		if(request.getParameter("conpro")!=null) {
			long codpro;
			PoductosDTO listapro;
			codpro=Long.parseLong(request.getParameter("codigo"));
			PoductosDTO podto=new PoductosDTO(codpro);
			ProductosDAO prodao=new ProductosDAO();
			listapro=prodao.consultarcliente(podto);
			sesion.setAttribute("producto",listapro);
			request.getRequestDispatcher("ventas.jsp").forward(request, response);
			
			
			
		} 
		
		if(request.getParameter("conpro1")!=null) {
			long codpro;
			PoductosDTO listapro;
			codpro=Long.parseLong(request.getParameter("codigo"));
			PoductosDTO podto=new PoductosDTO(codpro);
			ProductosDAO prodao=new ProductosDAO();
			listapro=prodao.consultarcliente(podto);
			sesion.setAttribute("producto1",listapro);
			request.getRequestDispatcher("ventas.jsp").forward(request, response);
			
			
			
		} 
		if(request.getParameter("conpro2")!=null) {
			long codpro;
			PoductosDTO listapro;
			codpro=Long.parseLong(request.getParameter("codigo"));
			PoductosDTO podto=new PoductosDTO(codpro);
			ProductosDAO prodao=new ProductosDAO();
			listapro=prodao.consultarcliente(podto);
			sesion.setAttribute("producto2",listapro);
			request.getRequestDispatcher("ventas.jsp").forward(request, response);
			
			
			
		} 
		int cant1,tot,res;
		
		
		if(request.getParameter("total")!=null) {
			
			cant1=Integer.parseInt(request.getParameter("can1"));
			tot=Integer.parseInt(request.getParameter("precio"));
			JOptionPane.showMessageDialog(null, "eeeee"+cant1+tot);
			res=cant1*tot;
			JOptionPane.showMessageDialog(null, res);
		}
		
	}

}
