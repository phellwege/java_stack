package com.peter.product_catagory.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="catagories_products")
public class MiddleTable {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name="product_id")
 private Product product;
 
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name="catagory_id")
 private Catagory catagory;
 
 public MiddleTable() {
     
 }


public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Date getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}

public Date getUpdatedAt() {
	return updatedAt;
}

public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}

public Product getProduct() {
	return product;
}

public void setProduct(Product product) {
	this.product = product;
}

public Catagory getCatagory() {
	return catagory;
}

public void setCategory(Catagory catagory) {
	this.catagory = catagory;
}

 // ...
}