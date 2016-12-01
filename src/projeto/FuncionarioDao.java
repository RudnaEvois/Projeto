/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import BD.GenericDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FuncionarioDao extends GenericDao {

    public void salvar(Funcionario funcionario) throws SQLException {
        String insert = "INSERT INTO FUNCIONÁRIOS(Matricula, Nome, Idade, Cargo, Salario,Telefone,Senha,admin) VALUES(?,?,?,?,?,?,?,?)";
        save(insert, funcionario.getMatricula(), funcionario.getNome(), funcionario.getCargo(), funcionario.getSalario(), funcionario.getTelefone(), funcionario.getSenha(), funcionario.getAdmin());

    }

    public List<Funcionario> findFuncionarios() throws SQLException {
        List<Funcionario> contatos = new ArrayList<Funcionario>();
        String select = "SELECT * FROM FUNCIONÁRIOS";
        PreparedStatement stmt
                = getConnection().prepareStatement(select);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Funcionario contato = new Funcionario();
            contato.setMatricula(rs.getString("Matricula"));
            contato.setNome(rs.getString("Nome"));
            contato.setIdade(rs.getInt("Idade"));
            contato.setCargo(rs.getString("Cargo"));
            contato.setSalario(rs.getFloat("Salario"));
            contato.setTelefone(rs.getString("Telefone"));
            contato.setSenha(rs.getString("Senha"));
            contato.setAdmin(rs.getInt("admin"));

            contatos.add(contato);
        }

        rs.close();
        stmt.close();

        return contatos;
    }
    public Funcionario findByMatricula(String Matricula) throws SQLException {
       String funcao=null;
        String select = "SELECT * FROM FUNCIONÁRIOS WHERE Matricula=?";
        Funcionario contato=null;
        PreparedStatement stmt
                = getConnection().prepareStatement(select);
stmt.setString(1,Matricula);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            
            contato.setMatricula(rs.getString("Matricula"));
            contato.setNome(rs.getString("Nome"));
            contato.setIdade(rs.getInt("Idade"));
            contato.setCargo(rs.getString("Cargo"));
            contato.setSalario(rs.getFloat("Salario"));
            contato.setTelefone(rs.getString("Telefone"));
            contato.setSenha(rs.getString("Senha"));
            contato.setAdmin(rs.getInt("admin"));
            ;
            
           if(contato.getAdmin()==1)
               funcao="Administrador";
           else
               funcao="Colaborador";
                   }
 JOptionPane.showMessageDialog(null, "Matricula do(a) Funcionário: " + contato.getMatricula() + "\n Nome: " + contato.getNome() + "\n Idade: "+ contato.getIdade()+"\n Cargo: "+contato.getCargo()+"\n Salário: "+contato.getSalario()+"\n Telefone: "+contato.getTelefone()+"\n Grupo:"+ funcao);
        
        rs.close();
        stmt.close();

        return contato;
    }
     public Funcionario findByName(String Nome) throws SQLException {
       String funcao=null;
        String select = "SELECT * FROM FUNCIONÁRIOS WHERE Nome=?";
        Funcionario contato=null;
        PreparedStatement stmt
                = getConnection().prepareStatement(select);
stmt.setString(1,Nome);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            
            contato.setMatricula(rs.getString("Matricula"));
            contato.setNome(rs.getString("Nome"));
            contato.setIdade(rs.getInt("Idade"));
            contato.setCargo(rs.getString("Cargo"));
            contato.setSalario(rs.getFloat("Salario"));
            contato.setTelefone(rs.getString("Telefone"));
            contato.setSenha(rs.getString("Senha"));
            contato.setAdmin(rs.getInt("admin"));
            ;
            
           if(contato.getAdmin()==1)
              funcao="Administrador";
           else
              funcao="Colaborador";
                   }
 JOptionPane.showMessageDialog(null, "Matricula do(a) Funcionário: " + contato.getMatricula() + "\n Nome: " + contato.getNome() + "\n Idade: "+ contato.getIdade()+"\n Cargo: "+contato.getCargo()+"\n Salário: "+contato.getSalario()+"\n Telefone: "+contato.getTelefone()+"\n Grupo:"+ funcao);
        
        rs.close();
        stmt.close();

        return contato;
    }

}
