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
@Table(name = "order")
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o"),
    @NamedQuery(name = "Order1.findById", query = "SELECT o FROM Order1 o WHERE o.id = :id"),
    @NamedQuery(name = "Order1.findByCreateDate", query = "SELECT o FROM Order1 o WHERE o.createDate = :createDate"),
    @NamedQuery(name = "Order1.findByTypeOrder", query = "SELECT o FROM Order1 o WHERE o.typeOrder = :typeOrder"),
    @NamedQuery(name = "Order1.findByPartnerId", query = "SELECT o FROM Order1 o WHERE o.partnerId = :partnerId"),
    @NamedQuery(name = "Order1.findByCreatorId", query = "SELECT o FROM Order1 o WHERE o.creatorId = :creatorId"),
    @NamedQuery(name = "Order1.findByStatus", query = "SELECT o FROM Order1 o WHERE o.status = :status"),
    @NamedQuery(name = "Order1.findByNote", query = "SELECT o FROM Order1 o WHERE o.note = :note")})
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "type_order")
    private String typeOrder;
    @Column(name = "partner_id")
    private Integer partnerId;
    @Column(name = "creator_id")
    private Integer creatorId;
    @Size(max = 50)
    @Column(name = "status")
    private String status;
    @Size(max = 255)
    @Column(name = "note")
    private String note;
    @OneToMany(mappedBy = "orderId")
    private Set<LogInventory> logInventorySet;
    @OneToMany(mappedBy = "orderId")
    private Set<Shipment> shipmentSet;
    @OneToMany(mappedBy = "orderId")
    private Set<ReviewSupplier> reviewSupplierSet;
    @OneToMany(mappedBy = "orderId")
    private Set<DeliverySchedule> deliveryScheduleSet;
    @OneToMany(mappedBy = "orderId")
    private Set<Invoice> invoiceSet;
    @OneToMany(mappedBy = "orderId")
    private Set<DetailOrder> detailOrderSet;
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Warehouse warehouseId;

    public Order() {
    }

    public Order(Integer id) {
        this.id = id;
    }

    public Order(Integer id, Date createDate, String typeOrder) {
        this.id = id;
        this.createDate = createDate;
        this.typeOrder = typeOrder;
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

    public String getTypeOrder() {
        return typeOrder;
    }

    public void setTypeOrder(String typeOrder) {
        this.typeOrder = typeOrder;
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

    public Set<Invoice> getInvoiceSet() {
        return invoiceSet;
    }

    public void setInvoiceSet(Set<Invoice> invoiceSet) {
        this.invoiceSet = invoiceSet;
    }

    public Set<DetailOrder> getDetailOrderSet() {
        return detailOrderSet;
    }

    public void setDetailOrderSet(Set<DetailOrder> detailOrderSet) {
        this.detailOrderSet = detailOrderSet;
    }

    public Warehouse getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Warehouse warehouseId) {
        this.warehouseId = warehouseId;
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
        if (!(object instanceof Order)) {
            return false;
        }
        Order other = (Order) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mesut.pojo.Order1[ id=" + id + " ]";
    }
    
}
