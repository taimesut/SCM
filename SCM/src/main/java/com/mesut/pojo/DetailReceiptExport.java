/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.pojo;

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
 * @author THANHTAI
 */
@Entity
@Table(name = "detail_receipt_export")
@NamedQueries({
    @NamedQuery(name = "DetailReceiptExport.findAll", query = "SELECT d FROM DetailReceiptExport d"),
    @NamedQuery(name = "DetailReceiptExport.findById", query = "SELECT d FROM DetailReceiptExport d WHERE d.id = :id"),
    @NamedQuery(name = "DetailReceiptExport.findByAmount", query = "SELECT d FROM DetailReceiptExport d WHERE d.amount = :amount"),
    @NamedQuery(name = "DetailReceiptExport.findByPrice", query = "SELECT d FROM DetailReceiptExport d WHERE d.price = :price")})
public class DetailReceiptExport implements Serializable ,Identifiable{

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
    @JoinColumn(name = "receipt_export_id", referencedColumnName = "id")
    @ManyToOne
    private ReceiptExport receiptExportId;

    public DetailReceiptExport() {
    }

    public DetailReceiptExport(Integer id) {
        this.id = id;
    }

    public DetailReceiptExport(Integer id, int amount, int price) {
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

    public ReceiptExport getReceiptExportId() {
        return receiptExportId;
    }

    public void setReceiptExportId(ReceiptExport receiptExportId) {
        this.receiptExportId = receiptExportId;
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
        if (!(object instanceof DetailReceiptExport)) {
            return false;
        }
        DetailReceiptExport other = (DetailReceiptExport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mesut.pojo.DetailReceiptExport[ id=" + id + " ]";
    }
    
}
