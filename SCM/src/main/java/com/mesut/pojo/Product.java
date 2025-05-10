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
@Table(name = "product")
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id"),
    @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price"),
    @NamedQuery(name = "Product.findByIsActive", query = "SELECT p FROM Product p WHERE p.isActive = :isActive"),
    @NamedQuery(name = "Product.findByCreateDate", query = "SELECT p FROM Product p WHERE p.createDate = :createDate"),
    @NamedQuery(name = "Product.findByUseDate", query = "SELECT p FROM Product p WHERE p.useDate = :useDate"),
    @NamedQuery(name = "Product.findByNote", query = "SELECT p FROM Product p WHERE p.note = :note")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Integer price;
    @Column(name = "is_active")
    private Boolean isActive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Column(name = "use_date")
    @Temporal(TemporalType.DATE)
    private Date useDate;
    @Size(max = 255)
    @Column(name = "note")
    private String note;
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne
    private Category categoryId;
    @OneToMany(mappedBy = "productId")
    private Set<LogInventory> logInventorySet;
    @OneToMany(mappedBy = "productId")
    private Set<Inventory> inventorySet;
    @OneToMany(mappedBy = "productId")
    private Set<DetailOrder> detailOrderSet;

    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Product(Integer id, String name, Date createDate) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUseDate() {
        return useDate;
    }

    public void setUseDate(Date useDate) {
        this.useDate = useDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Set<LogInventory> getLogInventorySet() {
        return logInventorySet;
    }

    public void setLogInventorySet(Set<LogInventory> logInventorySet) {
        this.logInventorySet = logInventorySet;
    }

    public Set<Inventory> getInventorySet() {
        return inventorySet;
    }

    public void setInventorySet(Set<Inventory> inventorySet) {
        this.inventorySet = inventorySet;
    }

    public Set<DetailOrder> getDetailOrderSet() {
        return detailOrderSet;
    }

    public void setDetailOrderSet(Set<DetailOrder> detailOrderSet) {
        this.detailOrderSet = detailOrderSet;
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mesut.pojo.Product[ id=" + id + " ]";
    }
    
}
