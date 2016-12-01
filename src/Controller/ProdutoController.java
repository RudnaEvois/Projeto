/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import projeto.ProdutoDao;
import projeto.Produto;
import javax.swing.*;

import java.sql.SQLException;

import java.text.ParseException;

import java.util.List; 
public class ProdutoController {
    public void salvar(String Cod, String Nome, int Quant, float VCusto,float VVenda)
            throws SQLException,ParseException{
        Produto contato=new Produto();
        contato.setCod(Cod);
        contato.setNome(Nome);
        contato.setQuant(Quant);
        contato.setValorCusto(VCusto);
        contato.setValorVenda(VVenda);
        new ProdutoDao().salvar(contato);
    }
    public List<Produto>listaProdutos(){
        ProdutoDao dao=new ProdutoDao();
        try{
            return dao.findProdutos();
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,
                    "Problemas ao localizar Produton"
                    + e.getLocalizedMessage()
            );
        }
        return null;
    }
    public Produto buscaProdutoPorCod(String Cod) throws SQLException{
        ProdutoDao dao=new ProdutoDao();
        try{
            return dao.findByCod(Cod);
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Problemas ao localizar Produton"
                    + e.getLocalizedMessage()
            );
        }
        return null;
        }
    public Produto buscaProdutoPorNome(String Nome) throws SQLException{
        ProdutoDao dao=new ProdutoDao();
        try{
            return dao.findByCod(Nome);
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Problemas ao localizar Produton"
                    + e.getLocalizedMessage()
            );
        }
        return null;
        }
    }

