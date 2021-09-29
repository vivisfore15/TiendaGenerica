<%@page import="javax.swing.JOptionPane"%>
<%@page import="Modelo.ClienteDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/stylesventas.css">

</head>
<body>






<h1>hola:${cliente.getCedula()}</h1>




   
<header id="contenedortitulo"   class="headerclass">
        <div class="logotitulo">
          <h1 id="titulop"  class="titulop">Mascotas felices </h1>
          <div class="logo"></div>
        </div>
        <nav class="navbar">
    
         
              <ul>
                  <li><a href="#">Mascotas</a></li>
                  <li><a href="#">Curiosidades </a></li>
                  <li><a href="#">Tips </a></li>
                  <li><a href="#">Alimentación </a></li>
                  <li><a href="#">Lugares </a></li>
                  <li><a href="#">Razas </a></li>
                  <li><a href="#">Eventos </a></li>
                  <li><a href="#">Deportes </a></li>
                 
              </ul>
        </nav>
        
      
              
      
    
      </header>
      <section>
          <fieldset>
              <legend>Gestión Ventas</legend>
                <form action="PruebaVenta" method="post">
                    <input type="text" name="cedula" value="${cliente.getCedula()}" placeholder="cedula">
                    <input type="text" name="nombre" value="${cliente.getNombre()}" placeholder="nombre">
                    <input type="submit" name="confirmar" value="confirmar" >
                    
<table>
    <tbody>
        <tr>
            <th>Codigo Del producto</th>
            <th>Seleccionar</th>
            <th>Nombre Del producto</th>
            <th>Cantidad Del producto</th>
            <th>Precio total Del producto</th>
        </tr>


        <tr>
            <td><input type="number" name="codigo" value="${producto.getCodigoproducto()}"  ></td>
            <td> <input type="submit" name="conpro" value="confirmar" ></td>
            <td> <input type="text" class="nombre" name="n2" value="${producto.getNombreproducto()}"  ></td>
            <td> <input type="number" class="cantidad" name="can1" value=""  ></td>
            <td> <input type="number" name="precio" value="${producto.getPreciocompra()}"  ></td>

        </tr>
        <tr>
            <td><input type="number" name="codigo" value="${producto1.getCodigoproducto()}"  ></td>
            <td> <input type="submit" name="conpro1" value="confirmar" ></td>
            <td> <input type="text" class="nombre" name="n2" value="${producto1.getNombreproducto()}"  ></td>
            <td> <input type="number" class="cantidad" name="can" value=""  ></td>
            <td> <input type="number" name="precio1" value="${producto1.getPreciocompra()}"  ></td>

        </tr>
        <tr>
           <td><input type="number" name="codigo" value="${producto2.getCodigoproducto()}"  ></td>
            <td> <input type="submit" name="conpro2" value="confirmar" ></td>
            <td> <input type="text" class="nombre" name="n2" value="${producto2.getNombreproducto()}"  ></td>
            <td> <input type="number" class="cantidad" name="precio1" value=""  ></td>
            <td> <input type="number" name="precio2" value="${producto2.getPreciocompra()}"  ></td>

        </tr>
        <tr><td class="ult" colspan="5"><input type="submit" name="total" value="Enviar venta"></td></tr>
        
    </tbody>
    </tbody>
</table>



                               

</form>


</fieldset>
      </section>
</body>
</html>