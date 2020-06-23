/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author escra
 */
public class ConexaoMysql {
    private static ConexaoMysql instance;
    private Connection connection;
    private ConexaoMysql() throws SQLException {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            //String url = "jdbc:mysql://localhost/bd_projetonotas";
            String url = "jdbc:mysql://db4free.net:3306/bd_teste_flavio";
            String configs = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
            String connectionString = url + configs;
            
            this.connection = DriverManager.getConnection(connectionString, "flavioandrade", "senhasecreta");
            //this.connection = DriverManager.getConnection(connectionString, "root", "");
            
            
        } catch (ClassNotFoundException ex) {
            
            System.out.println("Falha ao criar a conexão: " + ex.getMessage());
            
        }
    }
    
    public Connection getConnection(){
        return connection;
    }
    
    public static ConexaoMysql getInstance() throws SQLException {
        if(instance == null) {
            instance = new ConexaoMysql();
        } else if (instance.getConnection().isClosed()){
            instance = new ConexaoMysql();
        }
        
        return instance;
       
    }
    
}
