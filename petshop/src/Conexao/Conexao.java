/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


/**
 *
 * @author jonatas
 */
public class Conexao {
    
    private String url;
    private String usuario;
    private String Senha;
    private String driver;
    
    
    private static Conexao instancia = null;
    
    private Conexao(String resource){
        
       ResourceBundle bounder = ResourceBundle.getBundle(resource);
       
       this.url = bounder.getString("url");
       this.usuario = bounder.getString("user");
       this.Senha = bounder.getString("password");
       this.driver = bounder.getString("driver");
        
    }
    
    public static Conexao getInstance(String resource){
        
        if(instancia == null){
            instancia = new Conexao(resource);
        }
        return instancia; 
    }
    
    public Connection getConexao() throws SQLException{
        
        try {
            Class.forName(this.driver);
            return DriverManager.getConnection(this.url, this.usuario, this.Senha);
        } catch (ClassNotFoundException ex) {
            throw new SQLException(ex);
        }
         
    }

   
}
