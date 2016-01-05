/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Servico;
import Conexao.Sessao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonatas
 */
public class ServicoDAO implements InterfaceDAO<Servico> {

    private Connection conexao;
    private PreparedStatement statment;

    @Override
    public boolean inserir(Servico servico) {

        try {
            this.conexao = Sessao.abrir();
            String sql = "insert into participa (data, horario, custo, precoservico, id_animal, nomeanimal, nomedono, id_tiposervico, nomeservico, finalizado)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            this.statment = this.conexao.prepareStatement(sql);
            this.statment.setString(1, servico.getData());
            this.statment.setString(2, servico.getHorario());
            this.statment.setFloat(3, servico.getCusto());
            this.statment.setFloat(4, servico.getPrecoServico());
            this.statment.setInt(5, servico.getId_animal());
            this.statment.setString(6, servico.getNomeAnimal());
            this.statment.setString(7, servico.getNomeDonoAnimal());
            this.statment.setInt(8, servico.getId_tipoServico());
            this.statment.setString(9, servico.getNomeServico());
            this.statment.setBoolean(10, servico.isFinalizado());

            this.statment.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            this.conexao = Sessao.fecharConexao();
            this.statment = Sessao.fecharStatement();
        }
        return true;
    }

    @Override
    public boolean alterar(Servico servico) {

        try {
            this.conexao = Sessao.abrir();
            String sql = "update participa set(nomeservico, nomeanimal, data, horario) = (?, ?, ?, ?) where id_participa=?";
            this.statment = this.conexao.prepareStatement(sql);
            this.statment.setString(1, servico.getNomeServico());
            this.statment.setString(2, servico.getNomeAnimal());
            this.statment.setString(3, servico.getData());
            this.statment.setString(4, servico.getHorario());
            this.statment.setInt(5, servico.getId());
            this.statment.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.conexao = Sessao.fecharConexao();
            this.statment = Sessao.fecharStatement();
        }

        return true;
    }

    public List<Servico> listar() {

        List<Servico> lista = new ArrayList<Servico>();

        ResultSet rs;

        try {
            this.conexao = Sessao.abrir();
            String sql = "select * from participa order by id_participa";
            this.statment = this.conexao.prepareStatement(sql);
            rs = this.statment.executeQuery();
            while (rs.next()) {

                Servico servico = new Servico();
                servico.setId(rs.getInt("id_participa"));
                servico.setData(rs.getString("data"));
                servico.setHorario(rs.getString("horario"));
                servico.setPrecoServico(rs.getFloat("precoservico"));
                servico.setCusto(rs.getFloat("custo"));
                servico.setId_animal(rs.getInt("id_animal"));
                servico.setNomeAnimal(rs.getString("nomeanimal"));
                servico.setNomeDonoAnimal(rs.getString("nomedono"));
                servico.setId_tipoServico(rs.getInt("id_tiposervico"));
                servico.setNomeServico(rs.getString("nomeservico"));
                servico.setFinalizado(rs.getBoolean("finalizado"));

                lista.add(servico);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            this.conexao = Sessao.fecharConexao();
            this.statment = Sessao.fecharStatement();
        }
        return lista;

    }

    public Servico listarUm(int idServico) {

        Servico servico = new Servico();

        ResultSet rs;

        try {
            this.conexao = Sessao.abrir();
            String sql = "select * from participa where id_participa = ? order by id_participa";
            this.statment = this.conexao.prepareStatement(sql);
            this.statment.setInt(1, idServico);
            rs = this.statment.executeQuery();
            while (rs.next()) {

                servico.setId(rs.getInt("id_participa"));
                servico.setData(rs.getString("data"));
                servico.setHorario(rs.getString("horario"));
                servico.setCusto(rs.getInt("custo"));
                servico.setId_animal(rs.getInt("id_animal"));
                servico.setNomeAnimal(rs.getString("nomeanimal"));
                servico.setNomeDonoAnimal(rs.getString("nomedono"));
                servico.setId_tipoServico(rs.getInt("id_tiposervico"));
                servico.setNomeServico(rs.getString("nomeservico"));
                servico.setFinalizado(rs.getBoolean("finalizado"));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            this.conexao = Sessao.fecharConexao();
            this.statment = Sessao.fecharStatement();
        }
        return servico;

    }

    @Override
    public boolean deletar(int id) {

        try {
            this.conexao = Sessao.abrir();
            String sql = "delete from participa where id_participa = ?";
            this.statment = this.conexao.prepareStatement(sql);
            this.statment.setInt(1, id);
            this.statment.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.conexao = Sessao.fecharConexao();
            this.statment = Sessao.fecharStatement();
        }

        return true;
    }

    public void finalizarServico(int id) {

        try {
            this.conexao = Sessao.abrir();
            String sql = "update participa set(finalizado) = (?) where id_participa=? ";
            this.statment = this.conexao.prepareStatement(sql);
            this.statment.setBoolean(1, true);
            this.statment.setInt(2, id);
            this.statment.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.conexao = Sessao.fecharConexao();
            this.statment = Sessao.fecharStatement();
        }
    }

    public boolean verificaFinalizacao(int id) {

        ResultSet rs;
        try {
            this.conexao = Sessao.abrir();
            String sql = "select finalizado from participa where id_participa = ?";
            this.statment = this.conexao.prepareStatement(sql);
            this.statment.setInt(1, id);
            rs = this.statment.executeQuery();
            
            while (rs.next()) {
                
                if (rs.getBoolean("finalizado") == false) {
                    return true;
                } else {
                    return false;
                }

            }
        } catch (SQLException ex) {

            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            this.conexao = Sessao.fecharConexao();
            this.statment = Sessao.fecharStatement();
        }
        return false;
    }

}
