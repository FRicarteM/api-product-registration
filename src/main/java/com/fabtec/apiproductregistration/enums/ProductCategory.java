package com.fabtec.apiproductregistration.enums;

public enum ProductCategory {

	ACCESSORIES(1),
	BEAUTY_PRODUCTS(2),
	BOOKS(3),
	ELECTRONICS(4),
	FILMS(5),
	FOODS_DRINKS(6),
	GAMES(7),
	SPORT(8);
	
	private int categoryCode;

	private ProductCategory(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public int getCategoryCode() {
		return categoryCode;
	}
	
	public static ProductCategory valueOf(int categoryCode) {
			for(ProductCategory value : ProductCategory.values()) {
				if(categoryCode == value.getCategoryCode()) {
					return value;
				}
			}
			throw new IllegalArgumentException("Invalid status code");
	}
	
}
