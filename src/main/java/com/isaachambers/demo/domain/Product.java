package com.isaachambers.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	@Indexed(direction = IndexDirection.ASCENDING)
	private String productName;
	private String sku;
	private double amount;
	private List<Category> categories;
	private List<Supplier> suppliers;
	private List<Review> reviews;

	public Product(String id, String productName, String sku, double amount, List<Category> categories,
			List<Supplier> suppliers, List<Review> reviews) {
		super();
		this.id = id;
		this.productName = productName;
		this.sku = sku;
		this.categories = categories;
		this.suppliers = suppliers;
		this.reviews = reviews;
		this.amount = amount;
	}

	public Product() {
		this.categories = new ArrayList<>();
		this.suppliers = new ArrayList<>();
		this.reviews = new ArrayList<>();
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

}
