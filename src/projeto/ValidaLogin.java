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
public class ValidaLogin {

    private boolean aut = false;
    private boolean admin = false;

    public boolean isAut() {
        return aut;
    }

    public void setAut(boolean aut) {
        this.aut = aut;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    public List<Funcionario> func = new ArrayList<Funcionario>();

    void validarLogin(String matricula, String senha) throws LoginException, SQLException {
        Funcionario contato = new Funcionario();
        ResultSet rs = null;
        Connection cnn = ConnectionDB.getConnection();
        try {
            PreparedStatement sql = cnn.prepareStatement("SELECT * FROM FUNCIONÁRIOS WHERE Matricula =" + matricula);

            rs = sql.executeQuery();
            while (rs.next()) {

                contato.setMatricula(rs.getString("Matricula"));
                contato.setNome(rs.getString("Nome"));
                contato.setIdade(rs.getInt("Idade"));
                contato.setCargo(rs.getString("Cargo"));
                contato.setSalario(rs.getFloat("Salario"));
                contato.setTelefone(rs.getString("Telefone"));
                contato.setSenha(rs.getString("Senha"));
                contato.setAdmin(rs.getInt("admin"));
                func.add(contato);
            }
            if ((!contato.getMatricula().equals(matricula)) || !contato.getSenha().equals(senha)) {
             throw new LoginException();
            }
        } catch (LoginException e) {
            JOptionPane.showMessageDialog(null,e);
        }

        if ((contato.getMatricula().equals(matricula)) && contato.getSenha().equals(senha)) {
            System.out.println(matricula + " " + senha);

            setAut(true);
        } else {
            setAut(false);
        }
        if (isAut()) {
            if (contato.getAdmin() == 1) {
                setAdmin(true);
            }
            if (contato.getAdmin() == 0) {
                setAdmin(false);
            }
        } //else {
            //JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos");
        }

    }
    

