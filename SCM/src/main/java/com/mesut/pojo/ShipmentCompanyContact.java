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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

/**
 *
 * @author THANHTAIPC
 */
@Entity
@Table(name = "shipment_company_contact")
@NamedQueries({
    @NamedQuery(name = "ShipmentCompanyContact.findAll", query = "SELECT s FROM ShipmentCompanyContact s"),
    @NamedQuery(name = "ShipmentCompanyContact.findById", query = "SELECT s FROM ShipmentCompanyContact s WHERE s.id = :id"),
    @NamedQuery(name = "ShipmentCompanyContact.findByContent", query = "SELECT s FROM ShipmentCompanyContact s WHERE s.content = :content"),
    @NamedQuery(name = "ShipmentCompanyContact.findByNote", query = "SELECT s FROM ShipmentCompanyContact s WHERE s.note = :note")})
public class ShipmentCompanyContact implements Serializable  ,Identifiable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "content")
    private String content;
    @Size(max = 255)
    @Column(name = "note")
    private String note;
    @JoinColumn(name = "shipment_company_id", referencedColumnName = "id")
    @ManyToOne
    private ShipmentCompany shipmentCompanyId;

    public ShipmentCompanyContact() {
    }

    public ShipmentCompanyContact(Integer id) {
        this.id = id;
    }

    public ShipmentCompanyContact(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
        if (!(object instanceof ShipmentCompanyContact)) {
            return false;
        }
        ShipmentCompanyContact other = (ShipmentCompanyContact) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mesut.pojo.ShipmentCompanyContact[ id=" + id + " ]";
    }
    
}
