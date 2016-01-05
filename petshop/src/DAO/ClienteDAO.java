/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Cliente;
import Conexao.Sessao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author jonatas
 */
public class ClienteDAO implements InterfaceDAO<Cliente> {

    private Connection conexao;
    private PreparedStatement statment;
    

    @Override
    public boolean inserir(Cliente cliente) {

        try {
            this.conexao = Sessao.abrir();
            String sql = "insert into cliente(nome, rua, telefone, bairro, cep, numero) values (?, ?, ?, ?, ?, ?)";
            this.statment = this.conexao.prepareStatement(sql);

            this.statment.setString(1, cliente.getNome());
            this.statment.setString(2, cliente.getRua());
            this.statment.setString(3, cliente.getTelefone());
            this.statment.setString(4, cliente.getBairro());
            this.statment.setString(5, cliente.getCep());
            this.statment.setInt(6, cliente.getNumero());
            this.statment.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            this.conexao = Sessao.fecharConexao();
            this.statment = Sessao.fecharStatement();
        }
        return true;
    }

    public int buscarUltimoId(){
        ResultSet rs;
        int id = 0;
        try {
            this.conexao = Sessao.abrir();
            String sql = "select id_cliente from cliente order by id_cliente";
            this.statment = conexao.prepareStatement(sql);
            rs = this.statment.executeQuery();
            
            while(rs.next()){
                
                id = rs.getInt("id_cliente");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.conexao = Sessao.fecharConexao();
            this.statment = Sessao.fecharStatement();
        }
        return id;
    }

    @Override
    public boolean alterar(Cliente cliente) {

        try {
            this.conexao = Sessao.abrir();
            String sql = "update cliente set(nome, rua, telefone, bairro, cep, numero) = (?, ?, ?, ?, ?, ?) where id_cliente=?";
            this.statment = this.conexao.prepareStatement(sql);
            this.statment.setString(1, cliente.getNome());
            this.statment.setString(2, cliente.getRua());
            this.statment.setString(3, cliente.getTelefone());
            this.statment.setString(4, cliente.getBairro());
            this.statment.setString(5, cliente.getCep());
            this.statment.setInt(6, cliente.getNumero());
            this.statment.setInt(7, cliente.getId());
            this.statment.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            this.conexao = Sessao.fecharConexao();
            this.statment = Sessao.fecharStatement();
        }
        return true;
    }

    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<Cliente>();
        ResultSet rs;

        try {
            this.conexao = Sessao.abrir();
            String sql = "select * from cliente order by id_cliente";
            this.statment = this.conexao.prepareStatement(sql);
            rs = this.statment.executeQuery();
            while (rs.next()) {

                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                cliente.setRua(rs.getString("rua"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCep(rs.getString("cep"));
                cliente.setNumero(rs.getInt("numero"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setId(rs.getInt("id_cliente"));
                lista.add(cliente);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            this.conexao = Sessao.fecharConexao();
            this.statment = Sessao.fecharStatement();
        }
        return lista;
    }
    
    public List<Cliente> listar(JComboBox clientes) {
        List<Cliente> lista = new ArrayList<Cliente>();
        ResultSet rs;
        
                Cliente clienteDefault = new Cliente();
                clienteDefault.setNome("Default");
                clienteDefault.setRua("default");
                clienteDefault.setBairro("default");
                clienteDefault.setCep("default");
                clienteDefault.setNumero(0);
                clienteDefault.setTelefone("default");
                clienteDefault.setId(0);
                lista.add(clienteDefault);
        

        try {
            this.conexao = Sessao.abrir();
            String sql = "select * from cliente order by nome";
            this.statment = this.conexao.prepareStatement(sql);
            rs = this.statment.executeQuery();
            while (rs.next()) {
                
                clientes.addItem(rs.getString("nome"));
                
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                cliente.setRua(rs.getString("rua"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCep(rs.getString("cep"));
                cliente.setNumero(rs.getInt("numero"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setId(rs.getInt("id_cliente"));
                lista.add(cliente);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            this.conexao = Sessao.fecharConexao();
            this.statment = Sessao.fecharStatement();
        }
        return lista;
    }
    
    
    
    
    
    
    
    
    

    @Override
    public boolean deletar(int id) {

        this.conexao = Sessao.abrir();

        try {
            String sql = "delete from cliente where id_cliente=?";
            this.statment = this.conexao.prepareStatement(sql);
            this.statment.setInt(1, id);
            this.statment.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.conexao = Sessao.fecharConexao();
            this.statment = Sessao.fecharStatement();
        }

        return true;
    }

    public Cliente buscarCliente(int id) {

        ResultSet rs;
        Cliente cliente = null;
        try {
            this.conexao = Sessao.abrir();
            String sql = "select * from cliente where id_cliente=?";
            this.statment = this.conexao.prepareStatement(sql);
            this.statment.setInt(1, id);
            rs = this.statment.executeQuery();
            while (rs.next()) {

                cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                cliente.setRua(rs.getString("rua"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCep(rs.getString("cep"));
                cliente.setNumero(rs.getInt("numero"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setId(rs.getInt("id_cliente"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.conexao = Sessao.fecharConexao();
            this.statment = Sessao.fecharStatement();
        }
        return cliente;

    }

}
