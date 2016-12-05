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
            

    public void listarC() {
        ResultSet rs = null;
        Connection cnn = ConnectionDB.getConnection();
        try {
            String cod = JOptionPane.showInputDialog("Digite o código do Cliente ");
            PreparedStatement sql = cnn.prepareStatement("SELECT * FROM CLIENTES WHERE cod =" + cod);

            rs = sql.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCod(rs.getString("cod"));
                c.setNome(rs.getString("nome"));
                c.setEndereço(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));

                cli.add(c);

                JOptionPane.showMessageDialog(null, "Código do Cliente: " + c.getCod() + "\n Nome: " + c.getNome() + "\n E-mail: " + c.getEndereço() + "Telefone: " + c.getTelefone());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
public List<Funcionario> fun = new ArrayList<Funcionario>();
    public void listarF() {
        ResultSet rs = null;
        Connection cnn = ConnectionDB.getConnection();
        try {

            String cod = JOptionPane.showInputDialog("Digite a matricula do funcionário");
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
            
            JOptionPane.showMessageDialog(null, "Matricula do Funcionário: "+f.getMatricula()+"\n Nome: "+f.getNome()+"\n Cargo: "+f.getCargo()+"\n Idade: "+f.getIdade()+"\n Salario: "+f.getSalario()+"\n Telefone: "+f.getTelefone());}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Produto> prod = new ArrayList<Produto>();
    public void listarP() {
        ResultSet rs = null;
        Connection cnn = ConnectionDB.getConnection();
        try {

            String cod = JOptionPane.showInputDialog("Digite o Codigo no Produto:");
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
            
            JOptionPane.showMessageDialog(null, "Código do Produto: "+p.getCod()+"\n Nome: "+p.getNome()+"\n Quantidade: "+p.getQuant()+"\n Preço de Custo "+p.getValorCusto()+"\n Valor de Venda: "+p.getValorVenda());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*
      public List<Cliente> clin = new ArrayList<Cliente>();
   public void listarCporNome() {
        ResultSet rs = null;
        Connection cnn = ConnectionDB.getConnection();
        try {
            String Nome = JOptionPane.showInputDialog("Digite o nome do Cliente: ");
            PreparedStatement sql = cnn.prepareStatement("SELECT * FROM CLIENTES WHERE Nome =" + Nome);

            rs = sql.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCod(rs.getString("cod"));
                c.setNome(rs.getString("nome"));
                c.setEndereço(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));

                clin.add(c);

                JOptionPane.showMessageDialog(null, "Código do Cliente: " + c.getCod() + "\n Nome: " + c.getNome() + "\n E-mail: " + c.getEndereço() + "Telefone: " + c.getTelefone());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
   
public List<Funcionario> func = new ArrayList<Funcionario>();
    public void listarFporNome() {
        ResultSet rs = null;
        Connection cnn = ConnectionDB.getConnection();
        try {

            String cod = JOptionPane.showInputDialog("Digite o Nome do funcionário");
            PreparedStatement sql = cnn.prepareStatement("SELECT * FROM FUNCIONÁRIOS WHERE Nome =" + cod);

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
            
            JOptionPane.showMessageDialog(null, "Matricula do Funcionário: "+f.getMatricula()+"\n Nome: "+f.getNome()+"\n Cargo: "+f.getCargo()+"\n Idade: "+f.getIdade()+"\n Salario: "+f.getSalario()+"\n Telefone: "+f.getTelefone());}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
/*
    public List<Produto> prod = new ArrayList<Produto>();
    public void listarP() {
        ResultSet rs = null;
        Connection cnn = ConnectionDB.getConnection();
        try {

            String cod = JOptionPane.showInputDialog("Digite o Codigo no Produto:");
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
            
            JOptionPane.showMessageDialog(null, "Código do Produto: "+p.getCod()+"\n Nome: "+p.getNome()+"\n Quantidade: "+p.getQuant()+"\n Preço de Custo "+p.getValorCusto()+"\n Valor de Venda: "+p.getValorVenda());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
*/
}
