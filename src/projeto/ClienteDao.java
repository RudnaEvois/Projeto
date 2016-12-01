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

public class ClienteDao extends GenericDao {

    public void salvar(Cliente cliente) throws SQLException {
        String insert = "INSERT INTO CLIENTES(Cod,Nome,Email,Telefone) VALUES(?,?,?,?)";
        save(insert, cliente.getCod(), cliente.getNome(), cliente.getEndereço(), cliente.getTelefone());
    }

    public List<Cliente> findClientes() throws SQLException {
        List<Cliente> contatos = new ArrayList<Cliente>();
        String select = "SELECT * FROM CLIENTES";
        PreparedStatement stmt
                = getConnection().prepareStatement(select);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Cliente contato = new Cliente();
            contato.setCod(rs.getString("Cod"));
            contato.setNome(rs.getString("Nome"));
            contato.setEndereço(rs.getString("Email"));
            contato.setTelefone(rs.getString("Telefone"));

            contatos.add(contato);
        }
        rs.close();
        stmt.close();
        return contatos;
    }

    public Cliente findByCod(String Cod) throws SQLException {
        String select = "SELECT * FROM CLIENTES WHERE Cod=?";
        Cliente contato = null;
        PreparedStatement stmt
                = getConnection().prepareStatement(select);
        stmt.setString(1, Cod);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            contato.setCod(rs.getString("Cod"));
            contato.setNome(rs.getString("Nome"));
            contato.setEndereço(rs.getString("Email"));
            contato.setTelefone(rs.getString("Telefone"));
            ;
        }
        JOptionPane.showMessageDialog(null, "Código do Cliente: " + contato.getCod() + "\n Nome: " + contato.getNome() + "/n Email: " + contato.getEndereço() + "\n Telefone: " + contato.getTelefone());
        rs.close();
        stmt.close();
        return contato;
    }

    public Cliente findByNome(String Nome) throws SQLException {

        String select = "SELECT * FROM CLIENTES WHERE Nome=?";
        Cliente contato = null;
        PreparedStatement stmt
                = getConnection().prepareStatement(select);
        stmt.setString(1, Nome);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            contato.setCod(rs.getString("Cod"));
            contato.setNome(rs.getString("Nome"));
            contato.setEndereço(rs.getString("Email"));
            contato.setTelefone(rs.getString("Telefone"));
            ;
        }
        JOptionPane.showMessageDialog(null, "Código do Cliente: " + contato.getCod() + "\n Nome: " + contato.getNome() + "/n Email: " + contato.getEndereço() + "\n Telefone: " + contato.getTelefone());
        rs.close();
        stmt.close();
        return contato;
    }
}
