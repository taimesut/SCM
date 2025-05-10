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
@Table(name = "invoice")
@NamedQueries({
    @NamedQuery(name = "Invoice.findAll", query = "SELECT i FROM Invoice i"),
    @NamedQuery(name = "Invoice.findById", query = "SELECT i FROM Invoice i WHERE i.id = :id"),
    @NamedQuery(name = "Invoice.findByCreateDate", query = "SELECT i FROM Invoice i WHERE i.createDate = :createDate"),
    @NamedQuery(name = "Invoice.findByStatus", query = "SELECT i FROM Invoice i WHERE i.status = :status"),
    @NamedQuery(name = "Invoice.findByTotal", query = "SELECT i FROM Invoice i WHERE i.total = :total"),
    @NamedQuery(name = "Invoice.findByPaymentMethod", query = "SELECT i FROM Invoice i WHERE i.paymentMethod = :paymentMethod"),
    @NamedQuery(name = "Invoice.findByNote", query = "SELECT i FROM Invoice i WHERE i.note = :note"),
    @NamedQuery(name = "Invoice.findByPaymentDate", query = "SELECT i FROM Invoice i WHERE i.paymentDate = :paymentDate")})
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Size(max = 100)
    @Column(name = "status")
    private String status;
    @Column(name = "total")
    private Integer total;
    @Size(max = 100)
    @Column(name = "payment_method")
    private String paymentMethod;
    @Size(max = 255)
    @Column(name = "note")
    private String note;
    @Column(name = "payment_date")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @ManyToOne
    private Order orderId;

    public Invoice() {
    }

    public Invoice(Integer id) {
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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
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
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mesut.pojo.Invoice[ id=" + id + " ]";
    }
    
}
