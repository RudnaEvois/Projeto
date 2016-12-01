/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import projeto.ClienteDao;
import projeto.Cliente;
import javax.swing.*;

import java.sql.SQLException;

import java.text.ParseException;

import java.util.List;

public class ClienteController {
    public void salvar(String Cod, String Nome, String Email, String Telefone)
  throws SQLException, ParseException{
        Cliente contato=new Cliente();
        contato.setCod(Cod);
        contato.setNome(Nome);
        contato.setEndereço(Email);
        contato.setTelefone(Telefone);
        new ClienteDao().salvar(contato);
    }  
    public List<Cliente> listaClientes(){
        ClienteDao dao=new ClienteDao();
        try{
            return dao.findClientes();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Problemas ao localizar Clienten"+e.getLocalizedMessage()
            );
        }
        return null;
    }
    public Cliente buscaClientePorCod(String Cod) throws SQLException{
        ClienteDao dao=new ClienteDao();
        try{
            return dao.findByCod(Cod);
        }
        catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Problemas ao localizar Clienten"+e.getLocalizedMessage()
            );
                    }
        return null;
    }
      public Cliente buscaClientePorNome(String Nome) throws SQLException{
        ClienteDao dao=new ClienteDao();
        try{
            return dao.findByNome(Nome);
        }
        catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Problemas ao localizar Clienten"+e.getLocalizedMessage()
            );
                    }
        return null;
    }
}
