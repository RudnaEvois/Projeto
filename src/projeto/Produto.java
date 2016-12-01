/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

/**
 *
 * @author 20832
 */
public class Produto extends Cadastro{
    String Cod;
    int quant;
    float ValorCusto,ValorVenda;

    public String getCod() {
        return Cod;
    }

    public void setCod(String Cod) {
        this.Cod = Cod;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public float getValorCusto() {
        return ValorCusto;
    }

    public void setValorCusto(float ValorCusto) {
        this.ValorCusto = ValorCusto;
    }

    public float getValorVenda() {
        return ValorVenda;
    }

    public void setValorVenda(float ValorVenda) {
        this.ValorVenda = ValorVenda;
    }
    
    
}
