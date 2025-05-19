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
 * @author THANHTAI
 */
@Entity
@Table(name = "delivery_schedule")
@NamedQueries({
    @NamedQuery(name = "DeliverySchedule.findAll", query = "SELECT d FROM DeliverySchedule d"),
    @NamedQuery(name = "DeliverySchedule.findById", query = "SELECT d FROM DeliverySchedule d WHERE d.id = :id"),
    @NamedQuery(name = "DeliverySchedule.findByDate", query = "SELECT d FROM DeliverySchedule d WHERE d.date = :date"),
    @NamedQuery(name = "DeliverySchedule.findByAddress", query = "SELECT d FROM DeliverySchedule d WHERE d.address = :address"),
    @NamedQuery(name = "DeliverySchedule.findByStatus", query = "SELECT d FROM DeliverySchedule d WHERE d.status = :status"),
    @NamedQuery(name = "DeliverySchedule.findByNote", query = "SELECT d FROM DeliverySchedule d WHERE d.note = :note")})
public class DeliverySchedule implements Serializable ,Identifiable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 100)
    @Column(name = "address")
    private String address;
    @Size(max = 100)
    @Column(name = "status")
    private String status;
    @Size(max = 255)
    @Column(name = "note")
    private String note;
    @JoinColumn(name = "shipment_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Shipment shipmentId;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Shipment getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Shipment shipmentId) {
        this.shipmentId = shipmentId;
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
