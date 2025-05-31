/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
 * @author THANHTAI
 */
@Entity
@Table(name = "receipt_export")
@NamedQueries({
    @NamedQuery(name = "ReceiptExport.findAll", query = "SELECT r FROM ReceiptExport r"),
    @NamedQuery(name = "ReceiptExport.findById", query = "SELECT r FROM ReceiptExport r WHERE r.id = :id"),
    @NamedQuery(name = "ReceiptExport.findByCreateDate", query = "SELECT r FROM ReceiptExport r WHERE r.createDate = :createDate"),
    @NamedQuery(name = "ReceiptExport.findByStatus", query = "SELECT r FROM ReceiptExport r WHERE r.status = :status"),
    @NamedQuery(name = "ReceiptExport.findByNote", query = "SELECT r FROM ReceiptExport r WHERE r.note = :note"),
    @NamedQuery(name = "ReceiptExport.findByCustomerId", query = "SELECT r FROM ReceiptExport r WHERE r.customerId.id = :customerId")
})

public class ReceiptExport implements Serializable ,Identifiable{

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
    @OneToMany(mappedBy = "receiptExportId")
    @JsonIgnore
    private Set<DetailReceiptExport> detailReceiptExportSet;
    @OneToMany(mappedBy = "receiptExportId")
    @JsonIgnore
    private Set<LogInventory> logInventorySet;
    @OneToMany(mappedBy = "receiptExportId")
    @JsonIgnore
    private Set<Shipment> shipmentSet;
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne
    private User customerId;
    @JoinColumn(name = "creator_id", referencedColumnName = "id")
    @ManyToOne
    private User creatorId;
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Warehouse warehouseId;
    @OneToOne(mappedBy = "receiptExportId")
    private InvoiceExport invoiceExport;

    public ReceiptExport() {
    }

    public ReceiptExport(Integer id) {
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

    public Set<DetailReceiptExport> getDetailReceiptExportSet() {
        return detailReceiptExportSet;
    }

    public void setDetailReceiptExportSet(Set<DetailReceiptExport> detailReceiptExportSet) {
        this.detailReceiptExportSet = detailReceiptExportSet;
    }

    public Set<LogInventory> getLogInventorySet() {
        return logInventorySet;
    }

    public void setLogInventorySet(Set<LogInventory> logInventorySet) {
        this.logInventorySet = logInventorySet;
    }

    public Set<Shipment> getShipmentSet() {
        return shipmentSet;
    }

    public void setShipmentSet(Set<Shipment> shipmentSet) {
        this.shipmentSet = shipmentSet;
    }

    public User getCustomerId() {
        return customerId;
    }

    public void setCustomerId(User customerId) {
        this.customerId = customerId;
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

    public InvoiceExport getInvoiceExport() {
        return invoiceExport;
    }

    public void setInvoiceExport(InvoiceExport invoiceExport) {
        this.invoiceExport = invoiceExport;
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
        if (!(object instanceof ReceiptExport)) {
            return false;
        }
        ReceiptExport other = (ReceiptExport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mesut.pojo.ReceiptExport[ id=" + id + " ]";
    }
    
}
