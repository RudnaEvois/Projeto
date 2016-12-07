/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import BD.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class Consultar {

    public List<Cliente> cli = new ArrayList<Cliente>();
            

    public void listarC(String cod) {
        ResultSet rs = null;
        Connection cnn = ConnectionDB.getConnection();
        try {
            
            PreparedStatement sql = cnn.prepareStatement("SELECT * FROM CLIENTES WHERE cod =" + cod);

            rs = sql.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCod(rs.getString("cod"));
                c.setNome(rs.getString("nome"));
                c.setEndereço(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));

                cli.add(c);

               }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
public List<Funcionario> fun = new ArrayList<Funcionario>();
    public void listarF(String cod) {
        ResultSet rs = null;
        Connection cnn = ConnectionDB.getConnection();
        try {

         
            PreparedStatement sql = cnn.prepareStatement("SELECT * FROM FUNCIONÁRIOS WHERE matricula =" + cod);

            rs = sql.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setMatricula(rs.getString("matricula"));
                f.setNome(rs.getString("nome"));
                f.setCargo(rs.getString("cargo"));
               f.setIdade(rs.getInt("idade"));
                f.setSalario(rs.getFloat("salario"));
                f.setTelefone(rs.getString("telefone"));
                f.setSenha(rs.getString("senha"));
                f.setAdmin(rs.getInt("admin"));
                fun.add(f);
            
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Produto> prod = new ArrayList<Produto>();
    public void listarP(String cod) {
        ResultSet rs = null;
        Connection cnn = ConnectionDB.getConnection();
        try {

           
            PreparedStatement sql = cnn.prepareStatement("SELECT * FROM PRODUTOS WHERE Cod =" + cod);

            rs = sql.executeQuery();
            while (rs.next()) {
                Produto p = new Produto();
                p.setCod(rs.getString("Cod"));
                p.setNome(rs.getString("nome"));
                p.setQuant(rs.getInt("quant"));
               p.setValorCusto(rs.getFloat("VCusto"));
                p.setValorVenda(rs.getFloat("VVenda"));
              
                prod.add(p);
            
         }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
      public List<Cliente> clin = new ArrayList<Cliente>();
   public void listarCporNome(String Nome) {
        ResultSet rs = null;
        Connection cnn = ConnectionDB.getConnection();
        try {
         
            PreparedStatement sql = cnn.prepareStatement("SELECT * FROM CLIENTES WHERE Nome LIKE '%" + Nome+"%'");

            rs = sql.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCod(rs.getString("cod"));
                c.setNome(rs.getString("nome"));
                c.setEndereço(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));

                clin.add(c);

                 }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Cliente não encontrado.");
        }
    }
   
public List<Funcionario> func = new ArrayList<Funcionario>();
    public void listarFporNome(String nome) {
        ResultSet rs = null;
        Connection cnn = ConnectionDB.getConnection();
        try {

          
            PreparedStatement sql = cnn.prepareStatement("SELECT * FROM FUNCIONÁRIOS WHERE Nome LIKE '%" + nome+"%'");

            rs = sql.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setMatricula(rs.getString("matricula"));
                f.setNome(rs.getString("nome"));
                f.setCargo(rs.getString("cargo"));
               f.setIdade(rs.getInt("idade"));
                f.setSalario(rs.getFloat("salario"));
                f.setTelefone(rs.getString("telefone"));
                f.setSenha(rs.getString("senha"));
                f.setAdmin(rs.getInt("admin"));
                func.add(f);
            
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Produto> prodn = new ArrayList<Produto>();
    public void listarPporNome(String nome) {
        ResultSet rs = null;
        Connection cnn = ConnectionDB.getConnection();
        try {

           
            PreparedStatement sql = cnn.prepareStatement("SELECT * FROM PRODUTOS WHERE Nome LIKE '%" + nome+"%'");

            rs = sql.executeQuery();
            while (rs.next()) {
                Produto p = new Produto();
                p.setCod(rs.getString("Cod"));
                p.setNome(rs.getString("nome"));
                p.setQuant(rs.getInt("quant"));
                p.setValorCusto(rs.getFloat("VCusto"));
                p.setValorVenda(rs.getFloat("VVenda"));
              
                prodn.add(p);
            
           }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Produto não encontrado");
        }
    }

}
