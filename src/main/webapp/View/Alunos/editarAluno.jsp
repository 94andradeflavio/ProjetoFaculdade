<%@page import="Model.Aluno"%>
<%@include file="../../header.jsp" %>

<%
    Aluno aluno = (Aluno) request.getAttribute("aluno");
%>

<h2 class="text-center">Editar <%=aluno.getAluno()%></h2>
<div class="row marginTop">

    <div class="col-md-8">
        <form id="frmCadAluno" method="post" action="<%=raiz%>/aluno">
            <input type="hidden" name="idAluno" id="idAluno" value="<%=aluno.getIdAluno()%>" />
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">Nota 1:</span>
                </div>
                <input value="<%=aluno.getNota1()%>" id="nota1" name="nota1" type="number" step="0.1" class="form-control">
            </div>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">Nota 2:</span>
                </div>
                <input value="<%=aluno.getNota2()%>" id="nota2" name="nota2" type="number" step="0.1" class="form-control">
            </div>
            <button type="submit" class="btn btn-success">Salvar</button>
            <button type="button" class="btn btn-link"><a href="<%=raiz%>/aluno?acao=listar">Cancelar</a></button>
        </form>
    </div>
</div>
<%@include file="../../footer.jsp" %>