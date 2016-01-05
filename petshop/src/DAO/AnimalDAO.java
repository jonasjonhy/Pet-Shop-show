/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Animal;
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
public class AnimalDAO implements InterfaceDAO<Animal> {

    private Connection conexao;
    private PreparedStatement statment;

    @Override
    public boolean inserir(Animal animal) {

        try {
            this.conexao = Sessao.abrir();
            String sql = "insert into animal(nome, raca, especie, idade, id_cliente, sexo) values (?, ?, ?, ?, ?, ?)";
            this.statment = this.conexao.prepareStatement(sql);

            this.statment.setString(1, animal.getNome());
            this.statment.setString(2, animal.getRaca());
            this.statment.setString(3, animal.getEspecie());
            this.statment.setInt(4, animal.getIdade());
            this.statment.setInt(5, animal.getIdDono());
            this.statment.setString(6, animal.getSexo());
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

    @Override
    public boolean alterar(Animal animal) {

        try {
            this.conexao = Sessao.abrir();
            String sql = "update animal set(nome, raca, sexo, idade) = (?, ?, ?, ?) where id_animal=?";
            this.statment = this.conexao.prepareStatement(sql);

            this.statment.setString(1, animal.getNome());
            this.statment.setString(2, animal.getRaca());
            this.statment.setString(3, animal.getSexo());
            this.statment.setInt(4, animal.getIdade());
            this.statment.setInt(5, animal.getId());
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

    public List<Animal> listar(int idDono) {
        ResultSet rs;
        ArrayList<Animal> lista = new ArrayList<Animal>();

        try {
            this.conexao = Sessao.abrir();
            String sql = "select * from animal where id_cliente = ? order by id_animal";
            this.statment = this.conexao.prepareStatement(sql);
            this.statment.setInt(1, idDono);
            rs = this.statment.executeQuery();
            while (rs.next()) {
                Animal animal = new Animal();
                animal.setId(rs.getInt("id_animal"));
                animal.setNome(rs.getString("nome"));
                animal.setRaca(rs.getString("raca"));
                animal.setEspecie(rs.getString("especie"));
                animal.setIdade(rs.getInt("idade"));
                animal.setIdDono(rs.getInt("id_cliente"));
                animal.setSexo(rs.getString("sexo"));

                lista.add(animal);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            this.conexao = Sessao.fecharConexao();
            this.statment = Sessao.fecharStatement();
        }
        return lista;

    }

    public Cliente buscarODono(int idAnimal) {
        ResultSet rs;
        Cliente cliente = new Cliente();

        try {
            this.conexao = Sessao.abrir();
            String sql = "select id_cliente from animal where id_animal = ?";
            this.statment = this.conexao.prepareStatement(sql);
            this.statment.setInt(1, idAnimal);
            rs = this.statment.executeQuery();
            while (rs.next()) {
                cliente.setId(rs.getInt("id_cliente"));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            this.conexao = Sessao.fecharConexao();
            this.statment = Sessao.fecharStatement();
        }
        return cliente;

    }

    //METODO SÓ VAI SER USADO PARA ALTERAR O ANIMAL
    public Animal buscarUm(int id) {
        ResultSet rs;
        Animal animal = null;

        try {
            this.conexao = Sessao.abrir();
            String sql = "select * from animal where id_animal = ?";
            this.statment = this.conexao.prepareStatement(sql);
            this.statment.setInt(1, id);
            rs = this.statment.executeQuery();
            while (rs.next()) {

                animal = new Animal();
                animal.setId(rs.getInt("id_animal"));
                animal.setNome(rs.getString("nome"));
                animal.setRaca(rs.getString("raca"));
                animal.setEspecie(rs.getString("especie"));
                animal.setIdade(rs.getInt("idade"));
                animal.setIdDono(rs.getInt("id_cliente"));
                animal.setSexo(rs.getString("sexo"));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            this.conexao = Sessao.fecharConexao();
            this.statment = Sessao.fecharStatement();
        }
        return animal;

    }

    @Override
    public boolean deletar(int id) {

        try {
            this.conexao = Sessao.abrir();
            String sql = "delete from animal where id_animal = ?";
            this.statment = this.conexao.prepareStatement(sql);
            this.statment.setInt(1, id);
            this.statment.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.conexao = Sessao.fecharConexao();
            this.statment = Sessao.fecharStatement();
        }

        return true;
    }

    public boolean detelarTodos(int idDono) {

        try {
            this.conexao = Sessao.abrir();
            String sql = "delete from animal where id_cliente = ?";
            String comando = "DELETE animal, cliente from animal INNER JOIN cliente on cliente.id_cliente = animal.id_cliente WHERE animal.id_cliente = ?";
            this.statment = this.conexao.prepareStatement(sql);
            this.statment.setInt(1, idDono);

            this.statment.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.conexao = Sessao.fecharConexao();
            this.statment = Sessao.fecharStatement();
        }

        return true;
    }

    public List<Animal> listarTodos() {
        ResultSet rs;
        ArrayList<Animal> lista = new ArrayList<Animal>();

        try {
            this.conexao = Sessao.abrir();
            String sql = "select * from animal order by nome";
            this.statment = this.conexao.prepareStatement(sql);
            rs = this.statment.executeQuery();
            while (rs.next()) {
                Animal animal = new Animal();
                animal.setId(rs.getInt("id_animal"));
                animal.setNome(rs.getString("nome"));
                animal.setRaca(rs.getString("raca"));
                animal.setEspecie(rs.getString("especie"));
                animal.setIdade(rs.getInt("idade"));
                animal.setIdDono(rs.getInt("id_cliente"));
                animal.setSexo(rs.getString("sexo"));

                lista.add(animal);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            this.conexao = Sessao.fecharConexao();
            this.statment = Sessao.fecharStatement();
        }
        return lista;

    }

}
