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
@Table(name = "review_shipment_company")
@NamedQueries({
    @NamedQuery(name = "ReviewShipmentCompany.findAll", query = "SELECT r FROM ReviewShipmentCompany r"),
    @NamedQuery(name = "ReviewShipmentCompany.findById", query = "SELECT r FROM ReviewShipmentCompany r WHERE r.id = :id"),
    @NamedQuery(name = "ReviewShipmentCompany.findByNote", query = "SELECT r FROM ReviewShipmentCompany r WHERE r.note = :note"),
    @NamedQuery(name = "ReviewShipmentCompany.findByPerformance", query = "SELECT r FROM ReviewShipmentCompany r WHERE r.performance = :performance")})
public class ReviewShipmentCompany implements Serializable, Identifiable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "note")
    private String note;
    @Column(name = "performance")
    private Integer performance;
    @JoinColumn(name = "shipment_id", referencedColumnName = "id")
    @ManyToOne
    private Shipment shipmentId;
    @JoinColumn(name = "shipment_company_id", referencedColumnName = "id")
    @ManyToOne
    private ShipmentCompany shipmentCompanyId;

    public ReviewShipmentCompany() {
    }

    public ReviewShipmentCompany(Integer id) {
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

    public Integer getPerformance() {
        return performance;
    }

    public void setPerformance(Integer performance) {
        this.performance = performance;
    }

    public Shipment getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Shipment shipmentId) {
        this.shipmentId = shipmentId;
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
        if (!(object instanceof ReviewShipmentCompany)) {
            return false;
        }
        ReviewShipmentCompany other = (ReviewShipmentCompany) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mesut.pojo.ReviewShipmentCompany[ id=" + id + " ]";
    }
    
}
