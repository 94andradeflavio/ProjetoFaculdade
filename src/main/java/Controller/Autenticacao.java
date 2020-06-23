/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Usuario;
import ModeloDAO.AlunoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author escra
 */
public class Autenticacao extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String semail = request.getParameter("emailUsu");
        String ssenha = request.getParameter("senha");
            
        Usuario usu = new Usuario();
        usu.setEmail(semail);
        usu.setSenha(ssenha);
        
        AlunoDAO alunoDAO = new AlunoDAO();
        Usuario usuAutenticado = alunoDAO.autenticacao(usu);
        
        if(usuAutenticado != null){
            request.getRequestDispatcher("aluno.jsp").forward(request, response);
        }else {
            response.sendRedirect("index.jsp");
        }
        
    }

}
