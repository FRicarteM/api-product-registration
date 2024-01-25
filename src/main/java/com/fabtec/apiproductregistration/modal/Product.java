package com.fabtec.apiproductregistration.modal;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import com.fabtec.apiproductregistration.enums.ProductCategory;
import com.fabtec.apiproductregistration.enums.ProductType;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "products")
public class Product implements Serializable {

	private static final long serialVersionUID = -8499493484763414150L;
	
	@Id
	@SequenceGenerator(name = "products_seq", sequenceName = "products_seq", allocationSize = 1)
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "products_seq")
	private Long id;
	
	@Column(name = "product_name", nullable = false, length = 80)
	private String productName;
	
	@Column(nullable = false, length = 2)
	private Integer category;
	
	@Column(nullable = false, length = 20)
	private String brand;
	
	@Column(nullable = false, length = 2)
	private Integer type;
	
	@Column(nullable = false, length = 6)
	private double cost;
	
	//estoque
	@Column(nullable = false, length = 6)
	private double inventory;
	
	@Column(name = "registration_date", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime registrationDate;
	
	@Column(name = "update_date", nullable = true)
	@LastModifiedDate
	private LocalDateTime updateDate;

	public Product() {
	}

	public Product(Long id, String productName, ProductCategory category, String brand, ProductType type, double cost,
			double inventory, LocalDateTime registrationDate,
			LocalDateTime updateDate) {
		this.id = id;
		this.productName = productName;
		setCategory(category);;
		this.brand = brand;
		setType(type);;
		this.cost = cost;
		this.inventory = inventory;
		this.registrationDate = registrationDate;
		this.updateDate = updateDate;
	}



	public Long getId() {
		return id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public ProductCategory getCategory() {
		return ProductCategory.valueOf(category);
	}
	public void setCategory(ProductCategory category) {
		this.category = category.getCategoryCode();
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public ProductType getType() {
		return ProductType.valueOf(type);
	}
	public void setType(ProductType type) {
		this.type = type.getTypeCode();
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getInventory() {
		return inventory;
	}
	public void setInventory(double inventory) {
		this.inventory = inventory;
	}
	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, category, cost, id, inventory, productName, registrationDate,
				type, updateDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if(!(obj instanceof Product))
			return false;
		Product other = (Product) obj;
		return Objects.equals(brand, other.brand) 
				&& Objects.equals(category, other.category)
				&& Double.doubleToLongBits(cost) == Double.doubleToLongBits(other.cost) && Objects.equals(id, other.id)
				&& Double.doubleToLongBits(inventory) == Double.doubleToLongBits(other.inventory)
				&& Objects.equals(productName, other.productName)
				&& Objects.equals(registrationDate, other.registrationDate)
				&& Objects.equals(type, other.type) 
				&& Objects.equals(updateDate, other.updateDate);
	}

	public static ProductsBuilder builder() {
		return new ProductsBuilder();
	}
	
	public static class ProductsBuilder {
		
		private Long id;
		private String productName;
		private ProductCategory category;
		private String brand;
		private ProductType type;
		private double cost;
		private double inventory;
		private LocalDateTime registrationDate;
		private LocalDateTime updateDate;
		
		public ProductsBuilder() {
		}
		
		public ProductsBuilder id(Long id) {
			this.id = id;
			return this;
		}
		
		public ProductsBuilder productName(String productName) {
			this.productName = productName;
			return this;
		}
		
		public ProductsBuilder category(ProductCategory category) {
			this.category = category;
			return this;
		}
		
		public ProductsBuilder brand(String brand) {
			this.brand = brand;
			return this;
		}
		
		public ProductsBuilder type(ProductType type) {
			this.type = type;
			return this;
		}
		
		public ProductsBuilder cost(double cost) {
			this.cost = cost;
			return this;
		}
		
		public ProductsBuilder inventory(double inventory) {
			this.inventory = inventory;
			return this;
		}
		
		public ProductsBuilder registrationDate(LocalDateTime registrationDate) {
			this.registrationDate = registrationDate;
			return this;
		}
		
		public ProductsBuilder updateDate(LocalDateTime updateDate) {
			this.updateDate = updateDate;
			return this;
		}
		
		public Product build() {
			return new Product(id, 
								productName, 
								category, 
								brand, 
								type, 
								cost, 
								inventory,  
								registrationDate, 
								updateDate);
		}
		
		
	}
	
}
