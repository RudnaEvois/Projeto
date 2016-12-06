/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author 20832
 */
@Entity
@Table(name = "nf", catalog = "projeto", schema = "")
@NamedQueries({
    @NamedQuery(name = "Nf_1.findAll", query = "SELECT n FROM Nf_1 n"),
    @NamedQuery(name = "Nf_1.findByCodNF", query = "SELECT n FROM Nf_1 n WHERE n.nfPK.codNF = :codNF"),
    @NamedQuery(name = "Nf_1.findByCodCliente", query = "SELECT n FROM Nf_1 n WHERE n.codCliente = :codCliente"),
    @NamedQuery(name = "Nf_1.findByNomeCliente", query = "SELECT n FROM Nf_1 n WHERE n.nomeCliente = :nomeCliente"),
    @NamedQuery(name = "Nf_1.findByCodProduto", query = "SELECT n FROM Nf_1 n WHERE n.nfPK.codProduto = :codProduto"),
    @NamedQuery(name = "Nf_1.findByNomeProduto", query = "SELECT n FROM Nf_1 n WHERE n.nomeProduto = :nomeProduto"),
    @NamedQuery(name = "Nf_1.findByQuantidade", query = "SELECT n FROM Nf_1 n WHERE n.quantidade = :quantidade"),
    @NamedQuery(name = "Nf_1.findByValorUnit", query = "SELECT n FROM Nf_1 n WHERE n.valorUnit = :valorUnit"),
    @NamedQuery(name = "Nf_1.findByValorTotal", query = "SELECT n FROM Nf_1 n WHERE n.valorTotal = :valorTotal"),
    @NamedQuery(name = "Nf_1.findByTotal", query = "SELECT n FROM Nf_1 n WHERE n.total = :total")})
public class Nf_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NfPK nfPK;
    @Column(name = "CodCliente")
    private String codCliente;
    @Column(name = "NomeCliente")
    private String nomeCliente;
    @Column(name = "NomeProduto")
    private String nomeProduto;
    @Column(name = "Quantidade")
    private Integer quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ValorUnit")
    private Float valorUnit;
    @Column(name = "ValorTotal")
    private Float valorTotal;
    @Column(name = "Total")
    private Float total;

    public Nf_1() {
    }

    public Nf_1(NfPK nfPK) {
        this.nfPK = nfPK;
    }

    public Nf_1(int codNF, String codProduto) {
        this.nfPK = new NfPK(codNF, codProduto);
    }

    public NfPK getNfPK() {
        return nfPK;
    }

    public void setNfPK(NfPK nfPK) {
        this.nfPK = nfPK;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        String oldCodCliente = this.codCliente;
        this.codCliente = codCliente;
        changeSupport.firePropertyChange("codCliente", oldCodCliente, codCliente);
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        String oldNomeCliente = this.nomeCliente;
        this.nomeCliente = nomeCliente;
        changeSupport.firePropertyChange("nomeCliente", oldNomeCliente, nomeCliente);
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        String oldNomeProduto = this.nomeProduto;
        this.nomeProduto = nomeProduto;
        changeSupport.firePropertyChange("nomeProduto", oldNomeProduto, nomeProduto);
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        Integer oldQuantidade = this.quantidade;
        this.quantidade = quantidade;
        changeSupport.firePropertyChange("quantidade", oldQuantidade, quantidade);
    }

    public Float getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(Float valorUnit) {
        Float oldValorUnit = this.valorUnit;
        this.valorUnit = valorUnit;
        changeSupport.firePropertyChange("valorUnit", oldValorUnit, valorUnit);
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        Float oldValorTotal = this.valorTotal;
        this.valorTotal = valorTotal;
        changeSupport.firePropertyChange("valorTotal", oldValorTotal, valorTotal);
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        Float oldTotal = this.total;
        this.total = total;
        changeSupport.firePropertyChange("total", oldTotal, total);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nfPK != null ? nfPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nf_1)) {
            return false;
        }
        Nf_1 other = (Nf_1) object;
        if ((this.nfPK == null && other.nfPK != null) || (this.nfPK != null && !this.nfPK.equals(other.nfPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projeto.Nf_1[ nfPK=" + nfPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
