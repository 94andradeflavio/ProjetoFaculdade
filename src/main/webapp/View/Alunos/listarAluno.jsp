<%@page import="java.util.ArrayList"%>
<%@page import="Model.Aluno"%>
<%@include file="../../header.jsp" %>
<h2 class="text-center">Listar alunos</h2>
<p>
    <a class="btn btn-primary" href="<%=raiz%>/aluno?acao=adicionar" style="color: white" value="Adicionar">Adicionar</a>
</p>
<div class="row">
    <div class="col-md-6">
        <table class="table table-dark table-striped">
            <thead>
                <tr>
                    <th>Aluno</th>
                    <th>Nota 1</th>
                    <th>Nota 2</th>
                    <th>Média</th>
                    <th>Editar/Deletar</th>
                </tr>
            </thead>
            <tbody>
                
                <%
                    
                    ArrayList<Aluno> aluno = (ArrayList<Aluno>) request.getAttribute("aluno");
                    for(Aluno item : aluno){
                    
                        float nota1 = item.getNota1();
                        float nota2 = item.getNota2();
                        float media = (nota1 + nota2) / 2;
                %>
                
                <tr>
                    <td><%=item.getAluno()%></td>
                    <td><%=item.getNota1()%></td>
                    <td><%=item.getNota2()%></td>
                    <td><%=media%></td>
                    <td>
                        <a href="<%=raiz%>/aluno?acao=editar&idAluno=<%=item.getIdAluno()%>" class="btn btn-outline-warning">Editar</a>
                        <a href="<%=raiz%>/aluno?acao=deletar&idAluno=<%=item.getIdAluno()%>" class="btn btn-outline-danger">Excluir</a>
                    </td>
                </tr>
                
                <%
                    }
                %>
                
            </tbody>
        </table>
    </div>
</div>
<%@include file="../../footer.jsp" %>