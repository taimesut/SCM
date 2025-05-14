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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
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
    @NamedQuery(name = "DeliverySchedule.findByExpectedDate", query = "SELECT d FROM DeliverySchedule d WHERE d.expectedDate = :expectedDate"),
    @NamedQuery(name = "DeliverySchedule.findByActualDate", query = "SELECT d FROM DeliverySchedule d WHERE d.actualDate = :actualDate"),
    @NamedQuery(name = "DeliverySchedule.findByCreateDate", query = "SELECT d FROM DeliverySchedule d WHERE d.createDate = :createDate"),
    @NamedQuery(name = "DeliverySchedule.findByNote", query = "SELECT d FROM DeliverySchedule d WHERE d.note = :note")})
public class DeliverySchedule implements Serializable ,Identifiable{

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
    @Size(max = 255)
    @Column(name = "note")
    private String note;
    @JoinColumn(name = "shipment_id", referencedColumnName = "id")
    @OneToOne(optional = false)
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
