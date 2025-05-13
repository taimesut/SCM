/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.pojo;

import com.mesut.utils.Identifiable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @author THANHTAIPC
 */
@Entity
@Table(name = "detail_receipt_import")
@NamedQueries({
    @NamedQuery(name = "DetailReceiptImport.findAll", query = "SELECT d FROM DetailReceiptImport d"),
    @NamedQuery(name = "DetailReceiptImport.findById", query = "SELECT d FROM DetailReceiptImport d WHERE d.id = :id"),
    @NamedQuery(name = "DetailReceiptImport.findByAmount", query = "SELECT d FROM DetailReceiptImport d WHERE d.amount = :amount"),
    @NamedQuery(name = "DetailReceiptImport.findByPrice", query = "SELECT d FROM DetailReceiptImport d WHERE d.price = :price")})
public class DetailReceiptImport implements Serializable, Identifiable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private int price;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne
    private Product productId;
    @JoinColumn(name = "purpose_id", referencedColumnName = "id")
    @ManyToOne
    private Purpose purposeId;
    @JoinColumn(name = "receipt_import_id", referencedColumnName = "id")
    @ManyToOne
    private ReceiptImport receiptImportId;

    public DetailReceiptImport() {
    }

    public DetailReceiptImport(Integer id) {
        this.id = id;
    }

    public DetailReceiptImport(Integer id, int amount, int price) {
        this.id = id;
        this.amount = amount;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Purpose getPurposeId() {
        return purposeId;
    }

    public void setPurposeId(Purpose purposeId) {
        this.purposeId = purposeId;
    }

    public ReceiptImport getReceiptImportId() {
        return receiptImportId;
    }

    public void setReceiptImportId(ReceiptImport receiptImportId) {
        this.receiptImportId = receiptImportId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailReceiptImport)) {
            return false;
        }
        DetailReceiptImport other = (DetailReceiptImport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mesut.pojo.DetailReceiptImport[ id=" + id + " ]";
    }
    
}
