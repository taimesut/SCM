/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.pojo;

import com.mesut.utils.Identifiable;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

/**
 *
 * @author THANHTAIPC
 */
@Entity
@Table(name = "shipment")
@NamedQueries({
    @NamedQuery(name = "Shipment.findAll", query = "SELECT s FROM Shipment s"),
    @NamedQuery(name = "Shipment.findById", query = "SELECT s FROM Shipment s WHERE s.id = :id"),
    @NamedQuery(name = "Shipment.findByStatus", query = "SELECT s FROM Shipment s WHERE s.status = :status"),
    @NamedQuery(name = "Shipment.findByNote", query = "SELECT s FROM Shipment s WHERE s.note = :note")})
public class Shipment implements Serializable  ,Identifiable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "status")
    private String status;
    @Size(max = 255)
    @Column(name = "note")
    private String note;
    @JoinColumn(name = "receipt_export_id", referencedColumnName = "id")
    @ManyToOne
    private ReceiptExport receiptExportId;
    @JoinColumn(name = "shipment_company_id", referencedColumnName = "id")
    @OneToOne
    private ShipmentCompany shipmentCompanyId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "shipmentId")
    private DeliverySchedule deliverySchedule;
    @OneToOne(mappedBy = "shipmentId")
    private ReviewShipmentCompany reviewShipmentCompany;

    public Shipment() {
    }

    public Shipment(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public ReceiptExport getReceiptExportId() {
        return receiptExportId;
    }

    public void setReceiptExportId(ReceiptExport receiptExportId) {
        this.receiptExportId = receiptExportId;
    }

    public ShipmentCompany getShipmentCompanyId() {
        return shipmentCompanyId;
    }

    public void setShipmentCompanyId(ShipmentCompany shipmentCompanyId) {
        this.shipmentCompanyId = shipmentCompanyId;
    }

    public DeliverySchedule getDeliverySchedule() {
        return deliverySchedule;
    }

    public void setDeliverySchedule(DeliverySchedule deliverySchedule) {
        this.deliverySchedule = deliverySchedule;
    }

    public ReviewShipmentCompany getReviewShipmentCompany() {
        return reviewShipmentCompany;
    }

    public void setReviewShipmentCompany(ReviewShipmentCompany reviewShipmentCompany) {
        this.reviewShipmentCompany = reviewShipmentCompany;
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
        if (!(object instanceof Shipment)) {
            return false;
        }
        Shipment other = (Shipment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mesut.pojo.Shipment[ id=" + id + " ]";
    }
    
}
