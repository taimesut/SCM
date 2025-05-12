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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author THANHTAIPC
 */
@Entity
@Table(name = "receipt")
@NamedQueries({
    @NamedQuery(name = "Receipt.findAll", query = "SELECT r FROM Receipt r"),
    @NamedQuery(name = "Receipt.findById", query = "SELECT r FROM Receipt r WHERE r.id = :id"),
    @NamedQuery(name = "Receipt.findByCreateDate", query = "SELECT r FROM Receipt r WHERE r.createDate = :createDate"),
    @NamedQuery(name = "Receipt.findByTypeReceipt", query = "SELECT r FROM Receipt r WHERE r.typeReceipt = :typeReceipt"),
    @NamedQuery(name = "Receipt.findByPartnerId", query = "SELECT r FROM Receipt r WHERE r.partnerId = :partnerId"),
    @NamedQuery(name = "Receipt.findByCreatorId", query = "SELECT r FROM Receipt r WHERE r.creatorId = :creatorId"),
    @NamedQuery(name = "Receipt.findByStatus", query = "SELECT r FROM Receipt r WHERE r.status = :status"),
    @NamedQuery(name = "Receipt.findByNote", query = "SELECT r FROM Receipt r WHERE r.note = :note")})
public class Receipt implements Serializable, Identifiable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "type_receipt")
    private String typeReceipt;
    @Size(max = 50)
    @Column(name = "status")
    private String status;
    @Size(max = 255)
    @Column(name = "note")
    private String note;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "partner_id")
    private Integer partnerId;
    @Column(name = "creator_id")
    private Integer creatorId;
    @OneToMany(mappedBy = "receiptId")
    private Set<DetailReceipt> detailReceiptSet;
    @OneToMany(mappedBy = "receiptId")
    private Set<LogInventory> logInventorySet;
    @OneToMany(mappedBy = "receiptId")
    private Set<Shipment> shipmentSet;
    @OneToMany(mappedBy = "receiptId")
    private Set<ReviewSupplier> reviewSupplierSet;
    @OneToMany(mappedBy = "receiptId")
    private Set<DeliverySchedule> deliveryScheduleSet;
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Warehouse warehouseId;
    @OneToMany(mappedBy = "receiptId")
    private Set<Invoice> invoiceSet;

    public Receipt() {
    }

    public Receipt(Integer id) {
        this.id = id;
    }

    public Receipt(Integer id, Date createDate, String typeReceipt) {
        this.id = id;
        this.createDate = createDate;
        this.typeReceipt = typeReceipt;
    }

    @Override
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

    public String getTypeReceipt() {
        return typeReceipt;
    }

    public void setTypeReceipt(String typeReceipt) {
        this.typeReceipt = typeReceipt;
    }

    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }


    public Set<DetailReceipt> getDetailReceiptSet() {
        return detailReceiptSet;
    }

    public void setDetailReceiptSet(Set<DetailReceipt> detailReceiptSet) {
        this.detailReceiptSet = detailReceiptSet;
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

    public Set<ReviewSupplier> getReviewSupplierSet() {
        return reviewSupplierSet;
    }

    public void setReviewSupplierSet(Set<ReviewSupplier> reviewSupplierSet) {
        this.reviewSupplierSet = reviewSupplierSet;
    }

    public Set<DeliverySchedule> getDeliveryScheduleSet() {
        return deliveryScheduleSet;
    }

    public void setDeliveryScheduleSet(Set<DeliverySchedule> deliveryScheduleSet) {
        this.deliveryScheduleSet = deliveryScheduleSet;
    }

    public Warehouse getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Warehouse warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Set<Invoice> getInvoiceSet() {
        return invoiceSet;
    }

    public void setInvoiceSet(Set<Invoice> invoiceSet) {
        this.invoiceSet = invoiceSet;
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
        if (!(object instanceof Receipt)) {
            return false;
        }
        Receipt other = (Receipt) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mesut.pojo.Receipt[ id=" + id + " ]";
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
    
}
