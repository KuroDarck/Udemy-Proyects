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
</head>
<style type="text/css">
    body {
  background-image: url("man-7750139.svg");
  background-repeat: no-repeat;
  background-size: cover;
  background-position: left;
}
</style>
<body>
  <div class="modal-dialog modal-lg mt-4 modal-sm modal-lg ">
    <div class="modal-content">
      <form action="index.jsp" method="post">
        <div class="modal-header">
          <h5 class="modal-title h4 pb-2 mb-4 text-danger border-bottom border-danger">Insertar Mensaje</h5>
        </div>
        <div class="modal-body">
          <div class="mb-3">
            <label for="inputMensaje" class="form-label">Mensaje</label>
            <textarea id="inputMensaje" class="form-control border border-info" aria-describedby="Mensaje"
              name="mensaje" rows="3"></textarea>
            <div id="Help" class="form-text">Mind your spelling, please.</div>
          </div>
          <div class="mb-3">
            <label for="AutorInput" class="form-label">Autor</label>
            <input type="text" class="form-control border border-info" id="AutorInput" name="autor">
          </div>
        </div>
        <div class="modal-footer">
         <button type="submit" class="btn btn-outline-success m-1" name="save">Save changes</button>
        </div>
      </form>
    </div>
  </div>
  <%
  MensajeConsulta consulta = new MensajeConsulta();
  if(request.getParameter("save") != null) {
    Mensaje mensaje = new Mensaje(request.getParameter("mensaje"), request.getParameter("autor"));
    consulta.insertMensaje(mensaje);
  }
  %>
  <div class="modal-dialog modal-lg mt-4 modal-sm modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title h4 pb-2 mb-4 text-danger border-bottom border-danger">Mostrar Mensaje</h5>
      </div>
      <%
      List<Mensaje> mensa = consulta.selectMensaje();
      for (Mensaje m : mensa) {
      %>
      <div class="modal-body mb-2">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">
              <%= m.getAutor() %>
            </h5>
            <p class="card-text">
              <%= m.getMensaje() %>
            </p>
            <p class="blockquote-footer"><cite>
              <%= m.getFecha() %>
            </cite></p>
            <a href="editar.jsp?id=<%=m.getIdmensaje()%>&&mensaje=<%=m.getMensaje()%>&&autor=<%=m.getAutor()%>" class="card-link">Editar</a>
            <a href="delet.jsp?id=<%=m.getIdmensaje()%>" class="card-link">Eliminar</a>
          </div>
        </div>
      </div>
      <% } %>
    </div>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ZgA5kVo3D1RwSAOXPn8M7p15l8y9zj3z+4Mz+e5f/cJ2BBhqUf6+OrCXaRkfjus"
    crossorigin="anonymous"></script>
</body>
</html>
