package com.inventory.InventoryManagement.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String category;

	@Column(name = "sub_category")
	private String subCategory;

	@Column(name = "manufacturing_date")
	private LocalDate manufacturingDate;

	@Column(name = "expiry_date")
	private LocalDate expiryDate;

	private String specification;

	private BigDecimal price;

	private Integer stock;

	private String model;

	private String seller;

	private String location;

	private String brand;

	private String status;

	// Default Constructor
	public Inventory() {
	}

	// Parameterized Constructor
	public Inventory(Long id, String name, String category, String subCategory, LocalDate manufacturingDate,
			LocalDate expiryDate, String specification, BigDecimal price, Integer stock, String model, String seller,
			String location, String brand, String status) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.subCategory = subCategory;
		this.manufacturingDate = manufacturingDate;
		this.expiryDate = expiryDate;
		this.specification = specification;
		this.price = price;
		this.stock = stock;
		this.model = model;
		this.seller = seller;
		this.location = location;
		this.brand = brand;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public LocalDate getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(LocalDate manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
