package com.fabtec.apiproductregistration.data.vo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.fabtec.apiproductregistration.enums.ProductCategory;
import com.fabtec.apiproductregistration.enums.ProductType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Relation(collectionRelation = "Product")
@JsonPropertyOrder({"id", "productName", "category", "brand", "type", "cost", 
	"inventory", "registrationDate", "updateDate" })
public class ProductVo extends RepresentationModel<ProductVo> implements Serializable {

	private static final long serialVersionUID = -897842491746305414L;
	
	@JsonProperty(value = "id")
	private Long key;
	
	@Size(min = 0, max = 80,
			message = "Name out of size limit")
	@NotBlank(message = "The field must be filled")
	private String productName;
	
	@Size(min = 0, max = 2,
			message = "Number out of size limit")
	@Positive(message = "Number not be negative or zero")
	@NotBlank(message = "The field must be filled")
	private ProductCategory category;
	
	@Size(min = 0, max = 20,
			message = "Name out of size limit")
	@NotBlank(message = "The field must be filled")
	private String brand;
	
	@Size(min = 0, max = 2,
			message = "Number out of size limit")
	@Positive(message = "Number not be negative or zero")
	@NotBlank(message = "The field must be filled")
	private ProductType type;
	
	@Pattern(regexp = "\\d[\\d\\,\\.]+", 
			message = "The format is invalid")
	@Size(min = 0, max = 6,
			message = "Number out of size limit")
	@PositiveOrZero(message = "Number not be negative")
	@NotBlank(message = "The field must be filled")
	private double cost;
	
	@Size(min = 0, max = 6,
			message = "Number out of size limit")
	@PositiveOrZero(message = "Number not be negative")
	@NotBlank(message = "The field must be filled")
	private double inventory;
	
	private LocalDateTime registrationDate;
	
	private LocalDateTime updateDate;
	
	public ProductVo() {
	}
	
	public ProductVo(Long key, String productName, ProductCategory category, String brand, ProductType type, double cost,
			double inventory, LocalDateTime registrationDate, LocalDateTime updateDate) {
		this.key = key;
		this.productName = productName;
		setCategory(category);;
		this.brand = brand;
		setType(type);;
		this.cost = cost;
		this.inventory = inventory;
		this.registrationDate = registrationDate;
		this.updateDate = updateDate;
	}

	public Long getKey() {
		return key;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public ProductCategory getCategory() {
		return category;
	}
	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public ProductType getType() {
		return type;
	}
	public void setType(ProductType type) {
		this.type = type;
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
		return Objects.hash(brand, category, key, inventory, productName, registrationDate,
				type, updateDate, cost);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if(!(obj instanceof ProductVo))
			return false;
		ProductVo other = (ProductVo) obj;
		return Objects.equals(brand, other.brand) 
				&& Objects.equals(category, other.category)
				&& Objects.equals(key, other.key)
				&& Double.doubleToLongBits(inventory) == Double.doubleToLongBits(other.inventory)
				&& Objects.equals(productName, other.productName)
				&& Objects.equals(registrationDate, other.registrationDate)
				&& Objects.equals(type, other.type) 
				&& Objects.equals(updateDate, other.updateDate)
				&& Double.doubleToLongBits(cost) == Double.doubleToLongBits(other.cost);
	}

	
	public static ProductsVoBuilder builder() {
		return new ProductsVoBuilder();
	}
	
	public static class ProductsVoBuilder {
		
		private Long key;
		private String productName;
		private ProductCategory category;
		private String brand;
		private ProductType type;
		private double cost;
		private double inventory;
		private LocalDateTime registrationDate;
		private LocalDateTime updateDate;
		
		public ProductsVoBuilder() {
		}
		
		public ProductsVoBuilder key(Long key) {
			this.key = key;
			return this;
		}
		
		public ProductsVoBuilder productName(String productName) {
			this.productName = productName;
			return this;
		}
		
		public ProductsVoBuilder category(ProductCategory category) {
			this.category = category;
			return this;
		}
		
		public ProductsVoBuilder brand(String brand) {
			this.brand = brand;
			return this;
		}
		
		public ProductsVoBuilder type(ProductType type) {
			this.type = type;
			return this;
		}
		
		public ProductsVoBuilder cost(double cost) {
			this.cost = cost;
			return this;
		}
		
		public ProductsVoBuilder inventory(double inventory) {
			this.inventory = inventory;
			return this;
		}
		
		public ProductsVoBuilder registrationDate(LocalDateTime registrationDate) {
			this.registrationDate = registrationDate;
			return this;
		}
		
		public ProductsVoBuilder updateDate(LocalDateTime updateDate) {
			this.updateDate = updateDate;
			return this;
		}
		
		public ProductVo build() {
			return new ProductVo(key, 
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
