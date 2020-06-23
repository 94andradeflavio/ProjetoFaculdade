<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Login</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <style>
            .footer {
                background-color: #f2f2f2;
                padding: 25px;
                position: fixed;
                left: 0;
                bottom: 0;
                width: 100%;
                text-align: center;
            }
            .marginTop {
                margin-top: 30px;
                justify-content: center;
            }
        </style>
    </head>
    <body>


        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <a class="navbar-brand" href="#">Login</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavbar">

            </div>  
        </nav>
        <div class="container" style="padding-top: 13%;">

            <h1 class="text-center">Login</h1>
            <div class="row">
                <div class="col"></div>
                <div class="col-6 text-center">
                    <form id="frmAut" method="post" action="autenticacao">
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text">Email:</span>
                            </div>
                            <input value="" id="emailUsu" name="emailUsu" type="email" class="form-control">
                        </div>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text">Senha:</span>
                            </div>
                            <input value="" id="senha" name="senha" type="password" class="form-control">
                        </div>
                        <button type="submit" class="btn btn-success">Salvar</button>
                    </form>
                </div>
                <div class="col"></div>
            </div>

            <div class="jumbotron text-center footer" style="margin-bottom:0">
                <p>Desenvolvido por - Flávio Andrade<br />
                    Nem todos os direitos reservados.</p>
            </div>
        </div> <!-- End Container -->
    </body>
</html>