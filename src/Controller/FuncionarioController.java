/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import projeto.FuncionarioDao;
import projeto.Funcionario;
import javax.swing.*;

import java.sql.SQLException;

import java.text.ParseException;

import java.util.List;        
public class FuncionarioController {
     public void salvar(String Matricula, String Nome, int Idade, String Cargo, float Salario, String Telefone,String Senha,int admin)
            throws SQLException, ParseException {
        Funcionario contato = new Funcionario();
       contato.setMatricula(Matricula);
            contato.setNome(Nome);
            contato.setIdade(Idade);
            contato.setCargo(Cargo);
            contato.setSalario(Salario);
            contato.setTelefone(Telefone);
            contato.setSenha(Senha);
            contato.setAdmin(admin);
        new FuncionarioDao().salvar(contato);
    }
    public List<Funcionario> listaFuncionarios() {
        FuncionarioDao dao = new FuncionarioDao();
        try {
            return dao.findFuncionarios();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Problemas ao localizar Funcionárion"
                    + e.getLocalizedMessage()
            );
        }
        return null;
    }
    public Funcionario buscaFuncionarioPorMatricula(String Matricula) throws SQLException {
        FuncionarioDao dao = new FuncionarioDao();
        return dao.findByMatricula(Matricula);
    }

    public Funcionario buscaFuncionarioPorNome(String nome) throws SQLException {
        FuncionarioDao dao = new FuncionarioDao();
        return dao.findByName(nome);
    }
}
