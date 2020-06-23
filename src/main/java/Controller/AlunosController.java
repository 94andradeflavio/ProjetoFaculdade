/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aluno;
import ModeloDAO.AlunoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author escra
 */
public class AlunosController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acesso = "";
        String acao = request.getParameter("acao");
        AlunoDAO alunoDao = new AlunoDAO();
        
        switch(acao){
            case "listar":
                acesso = "View/Alunos/listarAluno.jsp";
                
                List<Aluno> listAluno = alunoDao.listar();
                request.setAttribute("aluno", listAluno);
                break;
            case "editar":
                acesso = "View/Alunos/editarAluno.jsp";
                Integer id = Integer.parseInt(request.getParameter("idAluno"));
                Aluno objAluno = alunoDao.listar(id);
                request.setAttribute("aluno", objAluno);
                break;
            case "adicionar":
                acesso = "View/Alunos/adicionarAluno.jsp";
                break;
            case "deletar":
                acesso = "View/Alunos/listarAluno.jsp";
                id = Integer.parseInt(request.getParameter("idAluno"));
                alunoDao.deletar(id);
                listAluno = alunoDao.listar();
                request.setAttribute("aluno", listAluno);
                break;
        
        }
        
        RequestDispatcher view = request.getRequestDispatcher(acesso);
        view.forward(request, response);
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AlunoDAO alunoDao = new AlunoDAO();
        
        String aluno = request.getParameter("aluno");
        String email = request.getParameter("email");
        String nota1 = request.getParameter("nota1");
        String nota2 = request.getParameter("nota2");
        
        Aluno objAlunoAdd = new Aluno();
        objAlunoAdd.setAluno(aluno);
        objAlunoAdd.setEmail(email);
        
        
        if(request.getParameter("idAluno") != null){
            Integer id = Integer.parseInt(request.getParameter("idAluno"));
            objAlunoAdd.setIdAluno(id);
            objAlunoAdd.setNota1(Float.parseFloat(nota1));
            objAlunoAdd.setNota2(Float.parseFloat(nota2));
            alunoDao.atualizar(objAlunoAdd);
            
        } else {
            alunoDao.Inserir(objAlunoAdd);
        }
        
        List<Aluno> listAluno = alunoDao.listar();
        request.setAttribute("aluno", listAluno);
        RequestDispatcher view = request.getRequestDispatcher("View/Alunos/listarAluno.jsp");
        view.forward(request, response);
        
    }

}
