package com.fabtec.apiproductregistration.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.fabtec.apiproductregistration.data.vo.ProductVo;
import com.fabtec.apiproductregistration.modal.Product;

public final class ProductMapper {

	public static Product voToProducts(ProductVo productVo) {
		
		Product product = Product.builder()
				.id(productVo.getKey())
				.productName(productVo.getProductName())
				.category(productVo.getCategory())
				.brand(productVo.getBrand())
				.type(productVo.getType())
				.cost(productVo.getCost())
				.inventory(productVo.getInventory())
				.registrationDate(productVo.getRegistrationDate())
				.updateDate(productVo.getUpdateDate())
				.build();
		return product;
	}
	
	public static ProductVo productsToVo(Product product) {
		
		ProductVo productVo = ProductVo.builder()
				.key(product.getId())
				.productName(product.getProductName())
				.category(product.getCategory())
				.brand(product.getBrand())
				.type(product.getType())
				.cost(product.getCost())
				.inventory(product.getInventory())
				.registrationDate(product.getRegistrationDate())
				.updateDate(product.getUpdateDate())
				.build();
		
		return productVo;
	}

	public static ProductVo productsToVoWithHateoas(Product product) {
		
		ProductVo productVo = ProductVo.builder()
				.key(product.getId())
				.productName(product.getProductName())
				.category(product.getCategory())
				.brand(product.getBrand())
				.type(product.getType())
				.cost(product.getCost())
				.inventory(product.getInventory())
				.registrationDate(product.getRegistrationDate())
				.updateDate(product.getUpdateDate())
				.build();
		
		//inserir hateoas
		
		return productVo;
	}
	
	public static List<ProductVo> productsToVoList(Page<Product> product){
		List<ProductVo> productVoList = product.stream()
						.map(ProductMapper::productsToVoWithHateoas)
						.collect(Collectors.toList());
		
		return productVoList;
	}
	
}
