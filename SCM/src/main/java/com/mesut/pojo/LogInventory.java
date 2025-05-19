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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author THANHTAI
 */
@Entity
@Table(name = "log_inventory")
@NamedQueries({
    @NamedQuery(name = "LogInventory.findAll", query = "SELECT l FROM LogInventory l"),
    @NamedQuery(name = "LogInventory.findById", query = "SELECT l FROM LogInventory l WHERE l.id = :id"),
    @NamedQuery(name = "LogInventory.findByAmount", query = "SELECT l FROM LogInventory l WHERE l.amount = :amount"),
    @NamedQuery(name = "LogInventory.findByPrice", query = "SELECT l FROM LogInventory l WHERE l.price = :price"),
    @NamedQuery(name = "LogInventory.findByCreateDate", query = "SELECT l FROM LogInventory l WHERE l.createDate = :createDate")})
public class LogInventory implements Serializable ,Identifiable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "price")
    private Integer price;
    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne
    private Product productId;
    @JoinColumn(name = "receipt_export_id", referencedColumnName = "id")
    @ManyToOne
    private ReceiptExport receiptExportId;
    @JoinColumn(name = "receipt_import_id", referencedColumnName = "id")
    @ManyToOne
    private ReceiptImport receiptImportId;

    public LogInventory() {
    }

    public LogInventory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
        if (!(object instanceof LogInventory)) {
            return false;
        }
        LogInventory other = (LogInventory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mesut.pojo.LogInventory[ id=" + id + " ]";
    }
    
}
