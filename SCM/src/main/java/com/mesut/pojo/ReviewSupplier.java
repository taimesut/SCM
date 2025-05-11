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
import jakarta.validation.constraints.Size;
import java.io.Serializable;

/**
 *
 * @author THANHTAIPC
 */
@Entity
@Table(name = "review_supplier")
@NamedQueries({
    @NamedQuery(name = "ReviewSupplier.findAll", query = "SELECT r FROM ReviewSupplier r"),
    @NamedQuery(name = "ReviewSupplier.findById", query = "SELECT r FROM ReviewSupplier r WHERE r.id = :id"),
    @NamedQuery(name = "ReviewSupplier.findByNote", query = "SELECT r FROM ReviewSupplier r WHERE r.note = :note"),
    @NamedQuery(name = "ReviewSupplier.findByPrice", query = "SELECT r FROM ReviewSupplier r WHERE r.price = :price"),
    @NamedQuery(name = "ReviewSupplier.findByQuality", query = "SELECT r FROM ReviewSupplier r WHERE r.quality = :quality"),
    @NamedQuery(name = "ReviewSupplier.findBySupport", query = "SELECT r FROM ReviewSupplier r WHERE r.support = :support")})
public class ReviewSupplier implements Serializable, Identifiable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "note")
    private String note;
    @Column(name = "price")
    private Integer price;
    @Column(name = "quality")
    private Integer quality;
    @Column(name = "support")
    private Integer support;
    @JoinColumn(name = "receipt_id", referencedColumnName = "id")
    @ManyToOne
    private Receipt receiptId;
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    @ManyToOne
    private Supplier supplierId;

    public ReviewSupplier() {
    }

    public ReviewSupplier(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Integer getSupport() {
        return support;
    }

    public void setSupport(Integer support) {
        this.support = support;
    }

    public Receipt getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Receipt receiptId) {
        this.receiptId = receiptId;
    }

    public Supplier getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Supplier supplierId) {
        this.supplierId = supplierId;
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
        if (!(object instanceof ReviewSupplier)) {
            return false;
        }
        ReviewSupplier other = (ReviewSupplier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mesut.pojo.ReviewSupplier[ id=" + id + " ]";
    }
    
}
