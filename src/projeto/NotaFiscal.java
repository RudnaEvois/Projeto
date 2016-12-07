/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;
import BD.GenericDao;
import BD.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author 20832
 */
public class NotaFiscal extends Consultar {
    String codC,nomeC,codP,nomeP;
    int quant,quantBD;
    float vUnit,vTotal,total;

    public String getCodC() {
        return codC;
    }

    public void setCodC(String codC) {
        this.codC=codC;
    }
    

    public String getNomeC() {
        return nomeC;
    }

    public void setNomeC(String nomeC) {
      this.nomeC=nomeC;
    }

    public String getCodP() {
        return codP;
    }

    public void setCodP(String codP) {
        this.codP = codP;
    }

    public String getNomeP() {
        return nomeP;
    }

    public void setNomeP(String nomeP) {
        this.nomeP = nomeP;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public float getvUnit() {
        return vUnit;
    }

    public void setvUnit(float vUnit) {
        this.vUnit = vUnit;
    }

    public float getvTotal() {
        return vTotal;
    }

    public void setvTotal(float vTotal) {
        this.vTotal = vTotal;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getQuantBD() {
        return quantBD;
    }

    public void setQuantBD(int quantBD) {
        this.quantBD = quantBD;
    }
public void nomeCliente(){
    ResultSet rs = null;
        Connection cnn = ConnectionDB.getConnection();
        try {
            
            PreparedStatement sql = cnn.prepareStatement("SELECT NOME FROM CLIENTES WHERE cod =" + getCodC());

            rs = sql.executeQuery();
            rs.next();
            setNomeC(rs.getString("nome"));
            
          

               
        } catch (SQLException e) {
            e.printStackTrace();
        }
}
    public void nomeProduto(){
    ResultSet rs = null;
        Connection cnn = ConnectionDB.getConnection();
        try {
            
            PreparedStatement sql = cnn.prepareStatement("SELECT NOME FROM PRODUTOS WHERE cod =" + getCodP());

            rs = sql.executeQuery();
            rs.next();
            setNomeP(rs.getString("nome"));
            
          

               
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void quantProduto(){
    ResultSet rs = null;
        Connection cnn = ConnectionDB.getConnection();
        try {
            
            PreparedStatement sql = cnn.prepareStatement("SELECT NOME,QUANT FROM PRODUTOS WHERE cod =" + getCodP());

            rs = sql.executeQuery();
            rs.next();
            setNomeP(rs.getString("nome"));
            setQuantBD(rs.getInt("quant"));
            
            
          

               
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public void reduzQuant(int quant){
        ResultSet rs = null;
        Connection cnn = ConnectionDB.getConnection();
        try {
          
        PreparedStatement pstmt = cnn.prepareStatement("UPDATE PRODUTOS SET Quant ="+quant+" WHERE cod ="+getCodP());
     
        pstmt.execute();
        pstmt.close();
            
            
          

               
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    }

