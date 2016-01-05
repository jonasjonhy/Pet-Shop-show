/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author jonatas
 */
public class Sessao {

    private static Connection conexao;
    private static PreparedStatement statment;
   
    private Sessao(){
    }
    
    public static Connection abrir() {

        try {
            if (conexao == null || conexao.isClosed()) {
                conexao = Conexao.getInstance("Conexao/jdbc")
                        .getConexao();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conexao;

    }
    
    public static Connection fecharConexao() {

        try {
            if (conexao != null) {
                conexao.close();
                conexao = null;
                return conexao;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexao;
    }
    
    public static PreparedStatement fecharStatement() {

        try {
            if (statment != null) {
                statment.close();
                statment = null;
                return statment;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statment;
    }
}
