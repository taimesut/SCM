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
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author THANHTAIPC
 */
@Entity
@Table(name = "delivery_schedule")
@NamedQueries({
    @NamedQuery(name = "DeliverySchedule.findAll", query = "SELECT d FROM DeliverySchedule d"),
    @NamedQuery(name = "DeliverySchedule.findById", query = "SELECT d FROM DeliverySchedule d WHERE d.id = :id"),
    @NamedQuery(name = "DeliverySchedule.findByExpectedDate", query = "SELECT d FROM DeliverySchedule d WHERE d.expectedDate = :expectedDate"),
    @NamedQuery(name = "DeliverySchedule.findByActualDate", query = "SELECT d FROM DeliverySchedule d WHERE d.actualDate = :actualDate"),
    @NamedQuery(name = "DeliverySchedule.findByCreateDate", query = "SELECT d FROM DeliverySchedule d WHERE d.createDate = :createDate"),
    @NamedQuery(name = "DeliverySchedule.findByTypeShipment", query = "SELECT d FROM DeliverySchedule d WHERE d.typeShipment = :typeShipment"),
    @NamedQuery(name = "DeliverySchedule.findByNote", query = "SELECT d FROM DeliverySchedule d WHERE d.note = :note")})
public class DeliverySchedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "expected_date")
    @Temporal(TemporalType.DATE)
    private Date expectedDate;
    @Column(name = "actual_date")
    @Temporal(TemporalType.DATE)
    private Date actualDate;
    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Size(max = 100)
    @Column(name = "type_shipment")
    private String typeShipment;
    @Size(max = 255)
    @Column(name = "note")
    private String note;
    @JoinColumn(name = "receipt_id", referencedColumnName = "id")
    @ManyToOne
    private Receipt receiptId;
    @JoinColumn(name = "shipment_company_id", referencedColumnName = "id")
    @ManyToOne
    private ShipmentCompany shipmentCompanyId;

    public DeliverySchedule() {
    }

    public DeliverySchedule(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    public Date getActualDate() {
        return actualDate;
    }

    public void setActualDate(Date actualDate) {
        this.actualDate = actualDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getTypeShipment() {
        return typeShipment;
    }

    public void setTypeShipment(String typeShipment) {
        this.typeShipment = typeShipment;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Receipt getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Receipt receiptId) {
        this.receiptId = receiptId;
    }

    public ShipmentCompany getShipmentCompanyId() {
        return shipmentCompanyId;
    }

    public void setShipmentCompanyId(ShipmentCompany shipmentCompanyId) {
        this.shipmentCompanyId = shipmentCompanyId;
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
        if (!(object instanceof DeliverySchedule)) {
            return false;
        }
        DeliverySchedule other = (DeliverySchedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mesut.pojo.DeliverySchedule[ id=" + id + " ]";
    }
    
}
