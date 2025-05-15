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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author THANHTAIPC
 */
@Entity
@Table(name = "receipt_import")
@NamedQueries({
    @NamedQuery(name = "ReceiptImport.findAll", query = "SELECT r FROM ReceiptImport r"),
    @NamedQuery(name = "ReceiptImport.findById", query = "SELECT r FROM ReceiptImport r WHERE r.id = :id"),
    @NamedQuery(name = "ReceiptImport.findByCreateDate", query = "SELECT r FROM ReceiptImport r WHERE r.createDate = :createDate"),
    @NamedQuery(name = "ReceiptImport.findByStatus", query = "SELECT r FROM ReceiptImport r WHERE r.status = :status"),
    @NamedQuery(name = "ReceiptImport.findByNote", query = "SELECT r FROM ReceiptImport r WHERE r.note = :note")})
public class ReceiptImport implements Serializable  ,Identifiable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Size(max = 50)
    @Column(name = "status")
    private String status;
    @Size(max = 255)
    @Column(name = "note")
    private String note;
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    @ManyToOne
    private Supplier supplierId;
    @JoinColumn(name = "creator_id", referencedColumnName = "id")
    @ManyToOne
    private User creatorId;
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Warehouse warehouseId;
    @OneToMany(mappedBy = "receiptImportId")
    private Set<LogInventory> logInventorySet;
    @OneToOne(mappedBy = "receiptImportId")
    private ReviewSupplier reviewSupplier;
    @OneToMany(mappedBy = "receiptImportId")
    private Set<DetailReceiptImport> detailReceiptImportSet;

    public ReceiptImport() {
    }

    public ReceiptImport(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Supplier getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Supplier supplierId) {
        this.supplierId = supplierId;
    }

    public User getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(User creatorId) {
        this.creatorId = creatorId;
    }

    public Warehouse getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Warehouse warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Set<LogInventory> getLogInventorySet() {
        return logInventorySet;
    }

    public void setLogInventorySet(Set<LogInventory> logInventorySet) {
        this.logInventorySet = logInventorySet;
    }

    public ReviewSupplier getReviewSupplier() {
        return reviewSupplier;
    }

    public void setReviewSupplier(ReviewSupplier reviewSupplier) {
        this.reviewSupplier = reviewSupplier;
    }

    public Set<DetailReceiptImport> getDetailReceiptImportSet() {
        return detailReceiptImportSet;
    }

    public void setDetailReceiptImportSet(Set<DetailReceiptImport> detailReceiptImportSet) {
        this.detailReceiptImportSet = detailReceiptImportSet;
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
        if (!(object instanceof ReceiptImport)) {
            return false;
        }
        ReceiptImport other = (ReceiptImport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mesut.pojo.ReceiptImport[ id=" + id + " ]";
    }
    
}
