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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author THANHTAI
 */
@Entity
@Table(name = "shipment_company")
@NamedQueries({
    @NamedQuery(name = "ShipmentCompany.findAll", query = "SELECT s FROM ShipmentCompany s"),
    @NamedQuery(name = "ShipmentCompany.findById", query = "SELECT s FROM ShipmentCompany s WHERE s.id = :id"),
    @NamedQuery(name = "ShipmentCompany.findByEmail", query = "SELECT s FROM ShipmentCompany s WHERE s.email = :email"),
    @NamedQuery(name = "ShipmentCompany.findByName", query = "SELECT s FROM ShipmentCompany s WHERE s.name = :name"),
    @NamedQuery(name = "ShipmentCompany.findByPhone", query = "SELECT s FROM ShipmentCompany s WHERE s.phone = :phone"),
    @NamedQuery(name = "ShipmentCompany.findByAddress", query = "SELECT s FROM ShipmentCompany s WHERE s.address = :address")})
public class ShipmentCompany implements Serializable , Identifiable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "address")
    private String address;
    @OneToOne(mappedBy = "shipmentCompanyId")
    private Shipment shipment;
    @OneToMany(mappedBy = "shipmentCompanyId")
    private Set<ShipmentCompanyContact> shipmentCompanyContactSet;

    public ShipmentCompany() {
    }

    public ShipmentCompany(Integer id) {
        this.id = id;
    }

    public ShipmentCompany(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public Set<ShipmentCompanyContact> getShipmentCompanyContactSet() {
        return shipmentCompanyContactSet;
    }

    public void setShipmentCompanyContactSet(Set<ShipmentCompanyContact> shipmentCompanyContactSet) {
        this.shipmentCompanyContactSet = shipmentCompanyContactSet;
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
        if (!(object instanceof ShipmentCompany)) {
            return false;
        }
        ShipmentCompany other = (ShipmentCompany) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mesut.pojo.ShipmentCompany[ id=" + id + " ]";
    }
    
}
