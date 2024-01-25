package com.fabtec.apiproductregistration.service;


import java.util.ArrayList;
import java.util.List;

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
import com.fabtec.apiproductregistration.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository;
	
	@Autowired
	PagedResourcesAssembler<ProductVo> assembler;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

	/* findAll FALTA HETEOAS
	 * findById OK
	 * findByProductName ok
	 * findByTypeok
	 * findByCategoryok
	 * remove
	 * save/cadastrar
	 * atualizar produto
	 * atualizar tipe e categoria (separados)
	 * atualizar quantidade para mais e para menos 
	 */
	
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
		
		Page<ProductVo> pageAddress = new PageImpl<>(products, pageable, products.size());
		
		//assembler.toModel(pageAddress, (tem que inserir o hateoas)link);
		return assembler.toModel(pageAddress);
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
		
		Page<ProductVo> pageAddress = new PageImpl<>(products, pageable, products.size());
		return assembler.toModel(pageAddress);
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
		
		Page<ProductVo> pageAddress = new PageImpl<>(products, pageable, products.size());
		return assembler.toModel(pageAddress);
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
		
		Page<ProductVo> pageAddress = new PageImpl<>(products, pageable, products.size());
		return assembler.toModel(pageAddress);
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
		
		Page<ProductVo> pageAddress = new PageImpl<>(products, pageable, products.size());
		return assembler.toModel(pageAddress);
	}
	
	
}
