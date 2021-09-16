<%@page import="javax.swing.JOptionPane"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!long cedula=0;
String nombre="",correo="",usuario="",pass=""; %>
<%
if(request.getParameter("cedula")!=null)
{
cedula= Long.parseLong(request.getParameter("cedula"));
nombre= request.getParameter("nombre");
correo= request.getParameter("correo");
usuario = request.getParameter("usuario");
pass = request.getParameter("pass");
JOptionPane.showMessageDialog(null, "Datos: "+cedula+" - "+nombre+" - "+correo+" - "+usuario+" - "+pass);
}
%>
<form action="Usuarios" method="post">
<div><label>Cedula</label><input type="text" name="cedula" value="<%=cedula %>"></div>
<div><label>Nombre</label><input type="text" name="nombre" value="<%=nombre %>"></div>
<div><label>Correo</label><input type="email" name="correo" value="<%=correo %>"></div>
<div><label>Usuario</label><input type="text" name="usuario" value="<%=usuario %>"></div>
<div><label>Contraseña</label><input type="password" name="pass" value="<%=pass %>"></div>
<div><input type="submit" name="consultar" value="Consultar">
<input type="submit" name="insertar" value="Registrar">
<input type="submit" name="actualizar" value="Actualizar">
<input type="submit" name="eliminar" value="Eliminar">
</div>
</form>


</body>
</html>