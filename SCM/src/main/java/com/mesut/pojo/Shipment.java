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
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author THANHTAIPC
 */
@Entity
@Table(name = "shipment")
@NamedQueries({
    @NamedQuery(name = "Shipment.findAll", query = "SELECT s FROM Shipment s"),
    @NamedQuery(name = "Shipment.findById", query = "SELECT s FROM Shipment s WHERE s.id = :id"),
    @NamedQuery(name = "Shipment.findByExportDate", query = "SELECT s FROM Shipment s WHERE s.exportDate = :exportDate"),
    @NamedQuery(name = "Shipment.findByShipDate", query = "SELECT s FROM Shipment s WHERE s.shipDate = :shipDate"),
    @NamedQuery(name = "Shipment.findByCreateDate", query = "SELECT s FROM Shipment s WHERE s.createDate = :createDate"),
    @NamedQuery(name = "Shipment.findByTypeShipment", query = "SELECT s FROM Shipment s WHERE s.typeShipment = :typeShipment"),
    @NamedQuery(name = "Shipment.findByNote", query = "SELECT s FROM Shipment s WHERE s.note = :note")})
public class Shipment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "export_date")
    @Temporal(TemporalType.DATE)
    private Date exportDate;
    @Column(name = "ship_date")
    @Temporal(TemporalType.DATE)
    private Date shipDate;
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
    @OneToMany(mappedBy = "shipmentId")
    private Set<ReviewShipmentCompany> reviewShipmentCompanySet;

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

    public Date getExportDate() {
        return exportDate;
    }

    public void setExportDate(Date exportDate) {
        this.exportDate = exportDate;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
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

    public Set<ReviewShipmentCompany> getReviewShipmentCompanySet() {
        return reviewShipmentCompanySet;
    }

    public void setReviewShipmentCompanySet(Set<ReviewShipmentCompany> reviewShipmentCompanySet) {
        this.reviewShipmentCompanySet = reviewShipmentCompanySet;
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
