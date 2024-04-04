package com.fabtec.apiproductregistration.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import com.fabtec.apiproductregistration.data.vo.ProductVo;
import com.fabtec.apiproductregistration.enums.ProductCategory;
import com.fabtec.apiproductregistration.enums.ProductType;
import com.fabtec.apiproductregistration.exceptions.BadRequestException;
import com.fabtec.apiproductregistration.exceptions.NotFoundException;
import com.fabtec.apiproductregistration.mapper.ProductMapper;
import com.fabtec.apiproductregistration.modal.Product;
import com.fabtec.apiproductregistration.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository;
	
	@Autowired
	PagedResourcesAssembler<ProductVo> assembler;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

	
	public ProductVo findById (Long id) {
		logger.info("Find the Product for Id registraiton");	
		return ProductMapper.productsToVo(repository.findById(id)
				.orElseThrow(()-> new NotFoundException("The Product not found!")));
	}
	
	public PagedModel<EntityModel<ProductVo>> findAll(Integer page){
		logger.info("Find Products");
		List<ProductVo> products = new ArrayList<>();
		Pageable pageable = PageRequest.of(page, 2, Sort.by("productName").ascending());
		
		try {
			products = ProductMapper.productsToVoList(repository.findAll(pageable));
		} catch (BadRequestException bre) {
			bre = new BadRequestException("Something wrong happened with your request");
		}
		
		Page<ProductVo> pageProduct = new PageImpl<>(products, pageable, products.size());
		
		//assembler.toModel(pageAddress, (tem que inserir o hateoas)link);
		return assembler.toModel(pageProduct);
	}
	
	public PagedModel<EntityModel<ProductVo>> findByProductName (Integer page, String name) {
		logger.info("Finder a Product by name");
		List<ProductVo> products = new ArrayList<>();
		Pageable pageable = PageRequest.of(page, 2, Sort.by("productName").ascending());
		
		try {
			products = ProductMapper.productsToVoList(repository.findByProductName(name, pageable));
		} catch (BadRequestException bre) {
			bre = new BadRequestException("Something wrong happened with your request");
		} catch (NotFoundException nfe) {
			nfe = new NotFoundException("The products were not found!");
		}
		
		Page<ProductVo> pageProduct = new PageImpl<>(products, pageable, products.size());
		
		//assembler.toModel(pageAddress, (tem que inserir o hateoas)link);
		return assembler.toModel(pageProduct);
	}
	
	public PagedModel<EntityModel<ProductVo>> findByBrand (Integer page, String brand) {
		logger.info("Finder a Product by brand");
		List<ProductVo> products = new ArrayList<>();
		Pageable pageable = PageRequest.of(page, 2, Sort.by("productName").ascending());
		
		try {
			products = ProductMapper.productsToVoList(repository.findByBrand(brand, pageable));
		} catch (BadRequestException bre) {
			bre = new BadRequestException("Something wrong happened with your request");
		} catch (NotFoundException nfe) {
			nfe = new NotFoundException("The products were not found!");
		}
		
		Page<ProductVo> pageProduct = new PageImpl<>(products, pageable, products.size());
		
		//assembler.toModel(pageAddress, (tem que inserir o hateoas)link);
		return assembler.toModel(pageProduct);
	}

	public PagedModel<EntityModel<ProductVo>> findByCategory (Integer page, ProductCategory category) {
		logger.info("Finder a Product by brand");
		List<ProductVo> products = new ArrayList<>();
		Pageable pageable = PageRequest.of(page, 2, Sort.by("productName").ascending());
		
		try {
			products = ProductMapper.productsToVoList(repository.findByCategory(category.getCategoryCode(), pageable));
		} catch (BadRequestException bre) {
			bre = new BadRequestException("Something wrong happened with your request");
		} catch (NotFoundException nfe) {
			nfe = new NotFoundException("The products were not found!");
		}
		
		Page<ProductVo> pageProduct = new PageImpl<>(products, pageable, products.size());
		
		//assembler.toModel(pageAddress, (tem que inserir o hateoas)link);
		return assembler.toModel(pageProduct);
	}
	
	public PagedModel<EntityModel<ProductVo>> findByType (Integer page, ProductType type) {
		logger.info("Finder a Product by brand");
		List<ProductVo> products = new ArrayList<>();
		Pageable pageable = PageRequest.of(page, 2, Sort.by("productName").ascending());
		
		try {
			products = ProductMapper.productsToVoList(repository.findByType(type.getTypeCode(), pageable));
		} catch (BadRequestException bre) {
			bre = new BadRequestException("Something wrong happened with your request");
		} catch (NotFoundException nfe) {
			nfe = new NotFoundException("The products were not found!");
		}
		
		Page<ProductVo> pageProduct = new PageImpl<>(products, pageable, products.size());
		
		//assembler.toModel(pageAddress, (tem que inserir o hateoas)link);
		return assembler.toModel(pageProduct);
	}
	
	public void save(ProductVo productVo) {
		logger.info("Insert a new Product");

		try {
			repository.save(ProductMapper.voToProducts(productVo));
		} catch (BadRequestException bre) {
			bre = new BadRequestException("Something wrong happened with your request");
		}

	}
	
	public void update(ProductVo productVo) {
		logger.info("Update Product");

		try {
			repository.update(productVo.getProductName(), productVo.getCategory(), productVo.getBrand(),
					productVo.getType(), productVo.getCost(), productVo.getInventory(), productVo.getUpdateDate(),
					productVo.getKey());
		} catch (BadRequestException bre) {
			bre = new BadRequestException("Something wrong happened with your request");
		}

	}	

	public void updateCategory(ProductCategory category, Long id) {
		logger.info("Update Category");
		
		try {
			repository.updateCategory(category, id);
		} catch (BadRequestException bre) {
			bre = new BadRequestException("Something wrong happened with your request");
		}
		
	}	

	public void updateType(ProductType type, Long id) {
		logger.info("Update Type");
		
		try {
			repository.updateType(type, id);
		} catch (BadRequestException bre) {
			bre = new BadRequestException("Something wrong happened with your request");
		}
		
	}	
	
	public void addProductInventory(Map<Long, Double> inventoryForAdd) {
		logger.info("add Product");
		try {
			for(Map.Entry<Long, Double> map : inventoryForAdd.entrySet()) {
				Product product;
				Long id = map.getKey();
				double inventory = map.getValue();
			
				product = ProductMapper.voToProducts(findById(id));
				double productIventory = product.getInventory();
				
				double inventoryAdd = productIventory + inventory;
				repository.updateIventory(inventoryAdd, id);
			}
		} catch (BadRequestException bre) {
			bre = new BadRequestException("Something wrong happened with your request");
		}
		
	}	
	
	public void removeProductInventory(Map<Long, Double> inventoryForRemove) {
		logger.info("add Product");
		try {
			for(Map.Entry<Long, Double> map : inventoryForRemove.entrySet()) {
				Product product;
				Long id = map.getKey();
				double inventory = map.getValue();
			
				product = ProductMapper.voToProducts(findById(id));
				double productIventory = product.getInventory();
				
				if(productIventory < inventory) {
					throw new BadRequestException("The number of items removed is greater "
							+ "than the number recorded in the inventory");
				}else {
					double inventoryRemove = productIventory - inventory;
					repository.updateIventory(inventoryRemove, id);
				}
			}
		} catch (BadRequestException bre) {
			bre = new BadRequestException("Something wrong happened with your request");
		}
		
	}
	
	public void remove (Long id) {
		logger.info("remove Product");
		// neste caso eu posso usar o método DELETE, passando todo o objeto
		// caso eu queira achar a entidade de alguma outra forma tipo um código de registro.
		try {
			repository.deleteById(id);
		}catch (BadRequestException bre) {
			bre = new BadRequestException("Something wrong happened with your request");
		}
			
	}
}
