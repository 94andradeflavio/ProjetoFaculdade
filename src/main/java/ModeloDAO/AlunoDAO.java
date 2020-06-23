/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.ConexaoMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Model.Aluno;
import Model.Usuario;
import java.sql.SQLException;

/**
 *
 * @author escra
 */
public class AlunoDAO {
    
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    
    public List listar() {
        ArrayList<Aluno> listarAlunos = new ArrayList<>();
        
        String sql = "select * from tb_aluno";
        
        try {
            connection = ConexaoMysql.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Aluno aluno = new Aluno();
                aluno.setIdAluno(resultSet.getInt("idAluno"));
                aluno.setAluno(resultSet.getString("aluno"));
                aluno.setNota1(resultSet.getFloat("nota1"));
                aluno.setNota2(resultSet.getFloat("nota2"));
                
                listarAlunos.add(aluno);
                
            }
            
        } catch (SQLException e){
            
        }
        return listarAlunos;
    }
    
    public Aluno listar(int id) {
        String sql = "select * from tb_aluno where idAluno = " + id;
        Aluno aluno = new Aluno();
        try {
            
            connection = ConexaoMysql.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                aluno.setIdAluno(resultSet.getInt("idAluno"));
                aluno.setAluno(resultSet.getString("aluno"));
                aluno.setNota1(resultSet.getFloat("nota1"));
                aluno.setNota2(resultSet.getFloat("nota2"));
            }
            
        } catch (SQLException e) {
        }
        return aluno;
    }
    
    public void Inserir(Aluno aluno) {
        String sql = "insert into tb_aluno(aluno, email) values(?, ?)";
        try {
            connection = ConexaoMysql.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, aluno.getAluno());
            preparedStatement.setString(2, aluno.getEmail());
            
            preparedStatement.execute();
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void atualizar(Aluno aluno) {
        String sql = "update tb_aluno set nota1 = ?, nota2 = ? where idAluno = ?";
        
        try {
            
            connection = ConexaoMysql.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            
            System.out.println("Nota 1: " + aluno.getNota1());
            System.out.println("Nota 2: " + aluno.getNota2());
            
            preparedStatement.setFloat(1, aluno.getNota1());
            preparedStatement.setFloat(2, aluno.getNota2());
            preparedStatement.setInt(3, aluno.getIdAluno());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar a nota: " + e.getMessage());
        }
        
    }
    
    public void deletar(int id){
        String sql = "delete from tb_aluno where idAluno = ?";
        
            try {
            connection = ConexaoMysql.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            
            
        } catch (SQLException e) {
        }
        
    }
    
    public Usuario autenticacao(Usuario usuario){
        Usuario usuRetorno = null;
        String sql = "select * from tb_usuario where email = ? and senha = ?";
        try {
            connection = ConexaoMysql.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getEmail());
            preparedStatement.setString(2, usuario.getSenha());
            
            ResultSet resultado = preparedStatement.executeQuery();
            
            if(resultado.next()){
                usuRetorno = new Usuario();
                usuRetorno.setIdUsuario(resultado.getInt("id"));
                usuRetorno.setNome(resultado.getString("nome"));
                usuRetorno.setEmail(resultado.getString("emailUsu"));
                usuRetorno.setSenha(resultado.getString("senha"));
            }
            
            
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return usuRetorno;
    }
    
}
