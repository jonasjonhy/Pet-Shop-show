/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Servico;
import Bean.TipoServico;
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
import javax.swing.JOptionPane;

/**
 *
 * @author jonatas
 */
public class TipoServicoDAO implements InterfaceDAO<TipoServico> {

    private Connection conexao;
    private PreparedStatement statment;

    @Override
    public boolean inserir(TipoServico servico) {

        try {
            this.conexao = Sessao.abrir();
            String sql = "INSERT INTO servico (nome, valor) VALUES (?, ?)";
            this.statment = this.conexao.prepareStatement(sql);
            this.statment.setString(1, servico.getNome());
            this.statment.setFloat(2, servico.getValor());
            this.statment.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TipoServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            this.conexao = Sessao.fecharConexao();
            this.statment = Sessao.fecharStatement();
        }

        return true;
    }

    @Override
    public boolean alterar(TipoServico servico) {

        try {
            this.conexao = Sessao.abrir();
            String sql = "update servico set(nome, valor) = (?, ?) where id_servico=?";
            this.statment = this.conexao.prepareStatement(sql);
            this.statment.setString(1, servico.getNome());
            this.statment.setFloat(2, servico.getValor());
            this.statment.setInt(3, servico.getId_servico());
            this.statment.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally{
            this.conexao = Sessao.fecharConexao();
            this.statment = Sessao.fecharStatement();
        }
        return true;
    }

    public List<TipoServico> listar(JComboBox servicos) {
        
        List<TipoServico> lista = new ArrayList<TipoServico>();
        
        //NECESSÁRIO ADICIONAR UM SERVIÇO DEFAULT PARA QUE O INDICE DE CADA SERVIÇO SEJA IGUAL AO SELECIONADO
        TipoServico servicoDefault = new TipoServico();
        servicoDefault.setId_servico(2015);
        servicoDefault.setNome("Default");
        servicoDefault.setValor(0);
        lista.add(servicoDefault);
        //CASO CONTÁRIO IRIA FICAR UM INDICE A MAIS DO QUE EXISTE NA LISTA, E AO SELECIONAR O ÚLTIMO RESULTARIA EM
        //NULPOINTEXCEPTION
        
        ResultSet rs;
        try {
            this.conexao = Sessao.abrir();
            String sql = "select * from servico order by id_servico";
            this.statment = this.conexao.prepareStatement(sql);
            rs = this.statment.executeQuery();
            while(rs.next()){
                TipoServico s = new TipoServico();
                //ADICIONANDO NO COMBOBOX CADA ITEM DA LISTA
                servicos.addItem(rs.getString("nome"));
                //ALIMENTANDO A LISTA COM OS SERVIÇOS
                s.setId_servico(rs.getInt("id_servico"));
                s.setNome(rs.getString("nome"));
                s.setValor(rs.getFloat("valor"));
                lista.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.conexao = Sessao.fecharConexao();
            this.statment = Sessao.fecharStatement();
        }
        
        
        return lista;

    }
    
    public List<TipoServico> listar() {
        
        List<TipoServico> lista = new ArrayList<TipoServico>();
        
        ResultSet rs;
        try {
            this.conexao = Sessao.abrir();
            String sql = "select * from servico order by id_servico";
            this.statment = this.conexao.prepareStatement(sql);
            rs = this.statment.executeQuery();
            while(rs.next()){
                TipoServico s = new TipoServico();
                
                s.setId_servico(rs.getInt("id_servico"));
                s.setNome(rs.getString("nome"));
                s.setValor(rs.getFloat("valor"));
                lista.add(s);
 
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.conexao = Sessao.fecharConexao();
            this.statment = Sessao.fecharStatement();
        }
        return lista;

    }
    
    public TipoServico listarUm(int idServico) {
        
        TipoServico tipoServico = new TipoServico();
        
        ResultSet rs;
        try {
            this.conexao = Sessao.abrir();
            String sql = "select * from servico where id_servico";
            this.statment = this.conexao.prepareStatement(sql);
            rs = this.statment.executeQuery();
            while(rs.next()){
                
                
                tipoServico.setId_servico(rs.getInt("id_servico"));
                tipoServico.setNome(rs.getString("nome"));
                tipoServico.setValor(rs.getFloat("valor"));
                
 
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.conexao = Sessao.fecharConexao();
            this.statment = Sessao.fecharStatement();
        }
        return tipoServico;

    }
    
    
    public TipoServico buscarPorId(int id){
        
        TipoServico ts = null;
        ResultSet rs;
        try {
            this.conexao = Sessao.abrir();
            String sql = "select * from servico where id_servico = ?";
            this.statment = this.conexao.prepareStatement(sql);
            this.statment.setInt(1, id);
            rs = this.statment.executeQuery();
            while(rs.next()){
                
                ts = new TipoServico();
                
                
                ts.setNome(rs.getString("nome"));
                ts.setValor(rs.getFloat("valor"));
                ts.setId_servico(rs.getInt("id_servico"));
                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.conexao = Sessao.fecharConexao();
            this.statment = Sessao.fecharStatement();
        }
        return ts;
        
        
        
    }

    @Override
    public boolean deletar(int id) {

        try {
            this.conexao = Sessao.abrir();
            String sql = "DELETE FROM servico where id_servico = ?";
            this.statment = this.conexao.prepareStatement(sql);
            this.statment.setInt(1, id);
            this.statment.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TipoServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally{
            this.conexao = Sessao.fecharConexao();
            this.statment = Sessao.fecharStatement();
        }
        return true;
    }

}
