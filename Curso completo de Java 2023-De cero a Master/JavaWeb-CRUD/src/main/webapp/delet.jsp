<%@ page import="java.util.*" %>
<%@ page import="src.main.SourceJava.*" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Web CRUD</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<%
MensajeConsulta consulta = new MensajeConsulta();
 String id = request.getParameter("id");
 Mensaje mensaje = new Mensaje(Integer.valueOf(id));
 consulta.deletMensaje(mensaje);
 request.getRequestDispatcher("index.jsp").forward(request, response);
%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ZgA5kVo3D1RwSAOXPn8M7p15l8y9zj3z+4Mz+e5f/cJ2BBhqUf6+OrCXaRkfjus"
    crossorigin="anonymous"></script>
</body>
</html>
