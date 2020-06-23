<%@include file="../../header.jsp" %>
<h2 class="text-center">Adicionar aluno</h2>
<div class="row marginTop">
    
    <div class="col-md-8">
        <form id="frmCadAluno" method="post" action="<%=raiz%>/aluno">
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">Aluno:</span>
                </div>
                <input value="" id="aluno" name="aluno" type="text" class="form-control">
            </div>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">Email:</span>
                </div>
                <input value="" id="email" name="email" type="email" class="form-control">
            </div>
            <button type="submit" class="btn btn-success">Salvar</button>
            <button type="reset" class="btn btn-link"><a href="<%=raiz%>/aluno?acao=listar">Cancelar</a></button>
        </form>
    </div>
</div>
<%@include file="../../footer.jsp" %>