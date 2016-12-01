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

public class ProdutoDao extends GenericDao {
    public void salvar(Produto produto) throws SQLException{
        String insert="INSERT INTO PRODUTOS(Cod,Nome,Quant,VCusto,VVenda) VALUES(?,?,?,?,?)";
        save(insert, produto.getCod(),produto.getNome(),produto.getQuant(),produto.getValorCusto(),produto.getValorVenda());
    }
    public List<Produto>findProdutos()throws SQLException{
        List<Produto> contatos=new ArrayList<>();
        String select="SELECT * FROM PRODUTOS";
        PreparedStatement stmt
                =getConnection().prepareStatement(select);
        ResultSet rs=stmt.executeQuery();
        while(rs.next()){
            Produto contato=new Produto();
            contato.setCod(rs.getString("Cod"));
            contato.setNome(rs.getString("Nome"));
            contato.setQuant(rs.getInt("Quant"));
            contato.setValorCusto(rs.getFloat("VCusto"));
            contato.setValorVenda(rs.getFloat("VVenda"));
            
            contatos.add(contato);
        }
        rs.close();
        stmt.close();
        
        return contatos;
    } 
    
    public Produto findByCod(String Cod) throws SQLException{
        String select="SELECT * FROM PRODUTOS WHERE Cod=?";
        Produto contato=null;
        PreparedStatement stmt
                =getConnection().prepareStatement(select);
        stmt.setString(1,Cod);
        ResultSet rs=stmt.executeQuery();
        while(rs.next()){
            
            contato.setCod(rs.getString("Cod"));
            contato.setNome(rs.getString("Nome"));
            contato.setQuant(rs.getInt("Quant"));
            contato.setValorCusto(rs.getFloat("VCusto"));
            contato.setValorVenda(rs.getFloat("VVenda"));
            ;
        }
            JOptionPane.showMessageDialog(null,"Código do produto: "+contato.getCod()+"\n Nome: "+contato.getNome()+"\n Quantidade: "+contato.getQuant()+"\n Preço de Custo: "+contato.getValorCusto()+"n Preço de Venda: "+contato.getValorVenda());
        
            rs.close();
            stmt.close();
            
            return contato;
        
    
    }
         public Produto findByName(String Nome) throws SQLException{
        String select="SELECT * FROM PRODUTOS WHERE Nome=?";
        Produto contato=null;
        PreparedStatement stmt
                =getConnection().prepareStatement(select);
        stmt.setString(1,Nome);
        ResultSet rs=stmt.executeQuery();
        while(rs.next()){
            
            contato.setCod(rs.getString("Cod"));
            contato.setNome(rs.getString("Nome"));
            contato.setQuant(rs.getInt("Quant"));
            contato.setValorCusto(rs.getFloat("VCusto"));
            contato.setValorVenda(rs.getFloat("VVenda"));
            ;
        }
            JOptionPane.showMessageDialog(null,"Código do produto: "+contato.getCod()+"\n Nome: "+contato.getNome()+"\n Quantidade: "+contato.getQuant()+"\n Preço de Custo: "+contato.getValorCusto()+"n Preço de Venda: "+contato.getValorVenda());
        
            rs.close();
            stmt.close();
            
            return contato;
    
         }
}
