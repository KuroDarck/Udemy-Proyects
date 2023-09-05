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
<style type="text/css">
    body {
  background-image: url("man-7750139.svg");
  background-repeat: no-repeat;
  background-size: cover;
  background-position: left;
}
</style>
<body>
  <div class="modal-dialog modal-sm modal-lg mt-4">
    <div class="modal-content">
      <form action="editar.jsp" method="post"> <!-- Change action to the appropriate URL -->
        <div class="modal-header">
          <h5 class="modal-title h4 pb-2 mb-4 text-danger border-bottom border-danger">Editar Mensaje</h5>
        </div>
        <div class="modal-body">
          <div class="mb-3">
            <input type="hidden" class="form-control border border-info" id="Idinput" name="id" value="<%= request.getParameter("id")%>">
            <label for="inputMensaje" class="form-label">Mensaje</label>
            <textarea id="inputMensaje" class="form-control border border-info" aria-describedby="Mensaje"
              name="mensaje" rows="3"><%= request.getParameter("mensaje") %></textarea>
            <div id="Help" class="form-text">Mind your spelling, please.</div>
          </div>
          <div class="mb-3">
            <label for="AutorInput" class="form-label">Autor</label>
            <input type="text" class="form-control border border-info" id="AutorInput" name="autor" value="<%= request.getParameter("autor")%>">
          </div>
        </div>
        <div class="modal-footer">
          <a href="index.jsp" class="btn btn-outline-danger m-1" data-bs-dismiss="modal">Back</a>
          <button type="submit" class="btn btn-outline-success m-1" name="save_change">Save changes</button>
        </div>
      </form>
    </div>
  </div>
<%
    MensajeConsulta consulta = new MensajeConsulta();
    String id = request.getParameter("id");
    if(request.getParameter("save_change") != null) {
      Mensaje mensaje = new Mensaje(Integer.parseInt(id.trim()),request.getParameter("mensaje"), request.getParameter("autor"));
      consulta.updateMensaje(mensaje);
    }
    %>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ZgA5kVo3D1RwSAOXPn8M7p15l8y9zj3z+4Mz+e5f/cJ2BBhqUf6+OrCXaRkfjus"
    crossorigin="anonymous"></script>
</body>
</html>
